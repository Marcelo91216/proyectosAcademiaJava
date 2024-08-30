package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "book_name")
	private String name;

	@Column(name = "edition")
	private String edition;

	@Column(name = "author")
	private String author;

	@Column(name = "sales")
	private int sales;

	public Book() {
		
	}

	public Book(String name, String edition, String author, int sales) {
		super();
		this.name = name;
		this.edition = edition;
		this.author = author;
		this.sales = sales;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", edition=" + edition + ", author=" + author + ", sales=" + sales
				+ "]";
	}

	
}
