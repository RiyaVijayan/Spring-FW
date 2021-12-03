package com.secondone.crud.repository;

import org.springframework.data.repository.CrudRepository;

import com.secondone.crud.model.Book;

public interface BooksRepository extends CrudRepository<Book, Integer> {


}
