package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
}
