package com.secondone.crud.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {

	@Id
	@Column
	private int bookid;
	@Column
	private String bookname;
	@Column
	private int bookprice;
	public int getBookId() {
		return bookid;
	}
	public void setBookId(int bookId) {
		this.bookid = bookId;
	}
	public String getBookName() {
		return bookname;
	}
	public void setBookName(String bookName) {
		this.bookname = bookName;
	}
	public int getBookPrice() {
		return bookprice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookprice = bookPrice;
	}
	
	
	
}
