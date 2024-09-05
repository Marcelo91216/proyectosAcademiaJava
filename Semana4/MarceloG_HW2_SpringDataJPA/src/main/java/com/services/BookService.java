package com.services;

import java.util.List;

import com.entities.Book;

public interface BookService {
	List<Book> getAll();

	void addBook(Book e);

	void removeBook(int id);

	Book getBookById(int id);
}
