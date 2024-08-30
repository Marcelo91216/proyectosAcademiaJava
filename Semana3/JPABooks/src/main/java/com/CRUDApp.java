package com;

import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dao.BookDAO;
import com.entity.Book;

@SpringBootApplication
public class CRUDApp {
	public static void main(String[] args) {
		SpringApplication.run(CRUDApp.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(BookDAO bookdao) {
		return runner -> {
//			insertDummyBook(bookdao);
			randomBooks(bookdao);
			getAllBooks(bookdao);
			findBookNo2(bookdao);
			deleteRandomBook(bookdao);
		};
	}

//	BackEnd - Database actions
	private void insertDummyBook(BookDAO bookdao) {
		System.out.println("> Inserting new dummy book");
		Book book = new Book("My Own CRUD", "Special Edition", "Marcelo", 9000);
		bookdao.save(book);
	}

	private void getAllBooks(BookDAO bookdao) {
		System.out.println("> Selecting all data...");
		List<Book> listOfBooks = bookdao.getAll();
		listOfBooks.stream().forEach(System.out::println);
	}
	
	private void randomBooks(BookDAO bookdao) {
		Random rand = new Random();
		Book book = new Book(
				rand.ints(97, 122+1)
					.limit(10)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
					.toString()
				,
				"Random",
				"Anonymous",
				rand.nextInt(9000)+1000
				);
		bookdao.save(book);
	}
	
	private void findBookNo2(BookDAO bookdao) {
		Book book = bookdao.findById(2);
		System.out.println("> Finding book #2...\n"+book);
	}
	
	private void deleteRandomBook(BookDAO bookdao) {
		int count = bookdao.getAll().size();
		bookdao.delete(new Random().nextInt(count)+1);
		System.out.println("> Deleting a random book...");
	}
}
