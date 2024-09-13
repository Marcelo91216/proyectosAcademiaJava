package com.dao;

import java.util.List;
import com.entity.Book;

public interface BookDAO {
	List<Book> findAll();

	Book getById(int id);

	void save(Book book);

	void deleteById(int id);
}
