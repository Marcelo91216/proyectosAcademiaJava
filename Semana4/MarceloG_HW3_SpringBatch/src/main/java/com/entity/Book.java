package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK_INFO")
public class Book {
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "YEAR")
	private int year;
	@Column(name = "GENRE")
	private String genre;
	@Column(name = "IS_READ")
	private boolean read;
}
