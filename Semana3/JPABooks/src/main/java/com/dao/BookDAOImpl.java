package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.entity.Book;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class BookDAOImpl implements BookDAO {
	private EntityManager entityManager;

	@Autowired
	public BookDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Book theBook) {
		entityManager.persist(theBook);

	}

	@Override
	public Book findById(int id) {
		return entityManager.find(Book.class, id);
	}

	@Override
	public List<Book> getAll() {
		TypedQuery<Book> query = entityManager.createQuery("FROM Book", Book.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void delete(int id) {
		entityManager.remove(entityManager.find(Book.class, id));
	}

}
