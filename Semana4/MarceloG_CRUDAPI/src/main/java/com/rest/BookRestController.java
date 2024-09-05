package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Book;
import com.service.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {
	private BookService service;

	@Autowired
	public BookRestController(BookService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public List<Book> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Book getById(@PathVariable int id) {
		Book book = service.getById(id);
		if (book == null)
			throw new RuntimeException("Book was not found");
		return book;
	}

	@PostMapping("/new")
	public String addBook(@RequestBody Book book) {
		book.setId(0);
		service.save(book);
		return "A new book was added!";
	}

	@PutMapping("/update")
	public String updateBook(@RequestBody Book book) {
		service.save(book);
		return "Your book was modified";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id) {
		Book book = service.getById(id);
		if (book == null)
			return "Book not found!!";
		else
			service.deleteById(id);
		return "The book was removed succefully";
	}
}
