package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookRepository;
import com.entities.Book;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService {
	private BookRepository repository;

	@Autowired
	public BookServiceImpl(BookRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Book> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void addBook(Book e) {
		repository.save(e);
	}

	@Override
	@Transactional
	public void removeBook(int id) {
		repository.deleteById(id);
	}

	@Override
	public Book getBookById(int id) {
//		return repository.getById(id); //MUCHO OJO, por culpa de este metodo obsoleto, no funcionara
		Optional<Book> res = repository.findById(id);
		Book temp = null;
		if(res.isPresent())
			temp = res.get();
		else
			throw new RuntimeException("Doesn't exist!!");
		return temp;
	}

}
