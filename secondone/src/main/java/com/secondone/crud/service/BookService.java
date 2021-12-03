package com.secondone.crud.service;

import java.util.ArrayList;
import java.util.List;

import com.secondone.crud.model.Book;
import com.secondone.crud.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BooksRepository bookrepository;
	
	public List<Book>getallBook()
	{
		List<Book>book=new ArrayList<Book>();
		bookrepository.findAll().forEach(book1->book.add(book1));
		return book;
	}
	public Book getBookById(int id)
	{
		return bookrepository.findById(id).get();
	}
	public void saveupdateBook(Book book)
	{
		bookrepository.save(book);
	}
	public void update(Book book,int bookid)
	{
		bookrepository.save(book);
	}
}
