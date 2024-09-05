package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Book;
import com.services.BookService;

@RestController
@RequestMapping("/")
public class BookController {
	private BookService service;

	@Autowired
	public BookController(BookService service) {
		this.service = service;
	}

	@GetMapping("/books")
	public List<Book> getAll() {
		return service.getAll();
	}

	@PostMapping("/new")
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}

	@GetMapping("/books/{bookId}")
	public Book getById(@PathVariable int bookId) {
		Book book =service.getBookById(bookId);
		if(book==null)
			throw new RuntimeException("Failed");
		return book;
	}

	@DeleteMapping("/remove/{id}")
	public void removeBook(@PathVariable int id) {
		service.removeBook(id);
	}
}
