package com.shoppingcart.org.repo;

import org.springframework.data.repository.CrudRepository;

import com.shoppingcart.org.model.Order;



public interface OrderRepo extends CrudRepository<Order, Integer> {

}
