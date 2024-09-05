package com.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import com.entity.Book;
import com.repo.BookRepository;

import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class Config {
	private JobBuilderFactory jobBuilderFactory;

	private StepBuilderFactory stepBuilderFactory;

	private BookRepository repo;

//	Especificamos como leera el archivo, como mapearlo
	private LineMapper<Book> lineMapper() {
		DefaultLineMapper<Book> mapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer dlt = new DelimitedLineTokenizer();
		dlt.setDelimiter(",");
		dlt.setStrict(true);
		dlt.setNames("ID", "TITLE", "AUTHOR", "YEAR", "GENRE", "READ");

		BeanWrapperFieldSetMapper<Book> setMapper = new BeanWrapperFieldSetMapper<Book>();
		setMapper.setTargetType(Book.class);

		mapper.setLineTokenizer(dlt);
		mapper.setFieldSetMapper(setMapper);
		return mapper;
	}

	@Bean
	public RepositoryItemWriter<Book> writer() {
		RepositoryItemWriter<Book> w = new RepositoryItemWriter<>();
		w.setRepository(repo);
		w.setMethodName("save");
		return w;
	}

	@Bean
	public FlatFileItemReader<Book> reader() {
		FlatFileItemReader<Book> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/books.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}

	@Bean
	public Step paso1() {
		return stepBuilderFactory.get("csv-step").<Book, Book>chunk(10).reader(reader())
				.processor((ItemProcessor<Book, Book>) book -> {
					if (book.getGenre().equals("Science Fiction") && book.getYear() >= 2023)
						return book;
					return null;
				}).writer(writer()).taskExecutor(taskExecutor()).build();
	}

	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor sate = new SimpleAsyncTaskExecutor();
		sate.setConcurrencyLimit(10);
		return sate;
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importBooks").flow(paso1()).end().build();
	}
}
