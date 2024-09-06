package com.service;

import java.util.List;

import com.entity.Book;

public interface BookService {
	List<Book> findAll();

	Book getById(int id);

	void save(Book book);

	void deleteById(int id);
}
