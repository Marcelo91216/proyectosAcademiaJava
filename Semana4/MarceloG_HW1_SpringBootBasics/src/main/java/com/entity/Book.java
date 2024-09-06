package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "author")
	private String author;

	@Column(name = "year")
	private int year;

	@Column(name = "genre")
	private String genre;

	@Column(name = "is_read")
	private boolean read;

	public Book(String title, String author, int year, String genre, boolean read) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.genre = genre;
		this.read = read;
	}

}
