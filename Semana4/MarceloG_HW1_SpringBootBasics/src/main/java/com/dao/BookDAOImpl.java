package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class BookDAOImpl implements BookDAO{
	private EntityManager manager;
	
	@Autowired
	public BookDAOImpl(EntityManager theManager) {
		this.manager = theManager;
	}
	
	@Override
	public List<Book> findAll() {
		TypedQuery<Book> query = manager.createQuery("from Book", Book.class);
		List<Book> books = query.getResultList();
		return books;
	}

	@Override
	public Book getById(int id) {
		return manager.find(Book.class, id);
	}

	@Override
	public void save(Book book) {
		manager.merge(book);
	}

	@Override
	public void deleteById(int id) {
		Book book = manager.find(Book.class, id);
		manager.remove(book);
	}
	
}
