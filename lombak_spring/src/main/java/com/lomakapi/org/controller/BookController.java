package com.lomakapi.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lombokapi.org.model.Product;
import com.lomokapi.org.repo.BookRepo;


@RestController
public class BookController {

	@Autowired
    private BookRepo repo;

	@GetMapping("/books")
	public List<Product>getAllBooks(){

		return(List<Product>)repo.findAll();
	}

	@PostMapping("/books")
	public Product createBook(@RequestBody Product product) {

        return repo.save(product);
    }

    @PutMapping ("/books/{id}")
    public ResponseEntity<Product> updateBook(@PathVariable(value = "id") Long bookId,
    		@RequestBody Product bookDetails) {

    	    Product product = repo.findById(bookId)
    	    		.orElseThrow(() -> new IllegalStateException("Product Id not found :: " + bookId));
    	    ;
    	    product.setName(bookDetails.getName());
	    	product.setDescription(bookDetails.getDescription());
	    	product.setPrice(bookDetails.getPrice());
            final Product updateBook = repo.save(product);
            return ResponseEntity.ok(updateBook);

    }

    @DeleteMapping ("/books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId) {
    	    Product product = repo.findById(bookId)
    	    		.orElseThrow(() -> new IllegalStateException("Product Id not found :: " + bookId));
            repo.delete(product);
            Map<String,Boolean> response = new HashMap < > ();
            response.put("deleted", Boolean.TRUE);
            return response;
    }
}
