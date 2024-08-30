package com.dao;

import com.entity.Book;
import java.util.List;

public interface BookDAO {
	void save(Book theBook);

	Book findById(int id);

	List<Book> getAll();

	void delete(int id);
}
