package com.lomokapi.org.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lombokapi.org.model.Product;
@Repository
public interface BookRepo extends CrudRepository<Product, Long> {
	

}
