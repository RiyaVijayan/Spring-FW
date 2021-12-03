package com.shoppingcart.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.org.model.Order;
import com.shoppingcart.org.model.Products;
import com.shoppingcart.org.repo.OrderRepo;
import com.shoppingcart.org.repo.ProductsRepo;


@RestController
@RequestMapping("/api")
public class ProductsController {

	@Autowired
    private ProductsRepo prepo;
	@Autowired
	private OrderRepo orepo;

	@GetMapping("/products")
	public List<Products> getAllProducts(){

		return(List <Products> )prepo.findAll();
	}

    @GetMapping ("/products/{productid}")
    public ResponseEntity<Products> getProduct(@PathVariable(value = "productid") int productId) {

    	    Products products = prepo.findById(productId)
    	    		.orElseThrow(() -> new IllegalStateException("Product not found :: " + productId));
    	   		
            return ResponseEntity.ok(products);

    }

	@PostMapping("/orders")
	public Order placeOrder(@RequestBody Order orders) {

        orepo.save(orders);
        return orders;
    }
    
    @DeleteMapping ("/orders/{orderid}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "orderid") int orderId) {
    	    Order orders = orepo.findById(orderId)
    	    		.orElseThrow(() -> new IllegalStateException("Product not found :: " + orderId));
            orepo.delete(orders);
            Map<String,Boolean> response = new HashMap < > ();
            response.put("deleted", Boolean.TRUE);
            return response;
    }
}
