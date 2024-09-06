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

//	We specified how file should be read and mapped
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

//	The ItemWriter of the process we are going to write the information into the database 
	@Bean
	public RepositoryItemWriter<Book> writer() {
		RepositoryItemWriter<Book> w = new RepositoryItemWriter<>();
		w.setRepository(repo);
		w.setMethodName("save");
		return w;
	}

//	The ItemReader of the step for the file lecture
	@Bean
	public FlatFileItemReader<Book> reader() {
		FlatFileItemReader<Book> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("src/main/resources/books.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(lineMapper());
		return itemReader;
	}

//	The step that is going to read the file, process all data and write new data to the database
	@Bean
	public Step paso1() {
		return stepBuilderFactory.get("csv-step").<Book, Book>chunk(10).reader(reader())
				.processor((ItemProcessor<Book, Book>) book -> {
					if (book.getGenre().equals("Science Fiction") && book.getYear() >= 2023)
						return book;
					return null;
				}).writer(writer()).taskExecutor(taskExecutor()).build();
	}

//	We configure a maximum of 10 concurrent processes for our data
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor sate = new SimpleAsyncTaskExecutor();
		sate.setConcurrencyLimit(10);
		return sate;
	}

//	Execute all the steps for our Job
	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importBooks").flow(paso1()).end().build();
	}
}
