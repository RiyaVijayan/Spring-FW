package com.product.api.productcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.product.Product;
import com.product.api.productrepo.ProductRepo;

@RestController
public class ProductController {
	Logger logger=LoggerFactory.getLogger(ProductController.class);

	@Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public List<Product> getProductList() {
    List<Product> productList = (List<Product>) productRepo.findAll();
    logger.info("Products are listed:"+ productList);
	return productList;
    }

	@PostMapping("/products")
    public Product createProduct( @RequestBody Product product) {

        logger.info("Product created "+ product);
    	return productRepo.save(product);

    }
    @PutMapping("/products/{id}")

    public ResponseEntity <Product> updateProduct(@PathVariable(value = "id") Long productId, @RequestBody Product productDetails) throws Throwable {
    	
    	Product product = productRepo.findOne(productId);
    			if(product==null)
    			{
    				logger.error("Product not found " + productId);
    				throw  new Exception("Product Id not found :: " + productId);
    			}
    
	    	product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            Product updateProduct = productRepo.save(product);
            logger.info("Product Updated " + updateProduct);
            return ResponseEntity.ok(updateProduct);

    }

    @DeleteMapping("/products/{id}")
    public Map < String, Boolean > deleteProduct(@PathVariable(value = "id") Long productId) throws Exception {

    	    Product product = productRepo.findOne(productId);
    	    
    		if(product==null)
    		{
				logger.error("Product not found  "+ productId);
    			throw  new Exception("Product Id not found :: " + productId);
    		}	

            productRepo.delete(productId);

            Map < String, Boolean > response = new HashMap < > ();

            response.put("deleted", Boolean.TRUE);
            logger.info("Product deleted " + productId);
            return response;

    }
}