package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.*;
import com.entity.Book;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService{
	private BookDAO bookdao;
	
	@Autowired
	public BookServiceImpl(BookDAO bookdao) {
		this.bookdao = bookdao;
	}
	
	@Override
	public List<Book> findAll() {
		return bookdao.findAll();
	}

	@Override
	public Book getById(int id) {
		return bookdao.getById(id);
	}

	@Transactional
	@Override
	public void save(Book book) {
		bookdao.save(book);
	}

	@Transactional
	@Override
	public void deleteById(int id) {
		bookdao.deleteById(id);
	}

}
