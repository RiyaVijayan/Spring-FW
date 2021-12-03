package com.shoppingcart.org.repo;


import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.org.model.Products;

public interface ProductsRepo extends CrudRepository<Products, Integer> {
	

}
