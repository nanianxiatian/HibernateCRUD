package com.sz.model;

/**
 * Book entity. @author MyEclipse Persistence Tools
 */

public class Book implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bookName;
	private String author;

	// Constructors

	/** default constructor */
	public Book() {
	}

	/** full constructor */
	public Book(String bookName, String author) {
		this.bookName = bookName;
		this.author = author;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}