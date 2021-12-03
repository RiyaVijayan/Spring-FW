package com.secondone.crud.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.secondone.crud.model.Book;
import com.secondone.crud.service.*;

@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.secondone.contoller")
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@GetMapping("/books")
	private List<Book>getallBook()
	{
		return bookservice.getallBook();
	}
	
	@PostMapping("/books")
	private int saveBook(@RequestBody Book book)
	{
		bookservice.saveupdateBook(book);
		return book.getBookId();
	}
	@PutMapping("/books")
	private Book update(@RequestBody Book book)
	{
		bookservice.saveupdateBook(book);
		return book;
	}

}
