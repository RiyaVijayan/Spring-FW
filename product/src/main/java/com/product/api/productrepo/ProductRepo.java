package com.product.api.productrepo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.product.api.product.Product;

@Component
public class ProductRepo {
	
	private static int productCount=6;
	public static List<Product> product = new ArrayList<>();
	
	static
	{
		product.add(new Product(101,"BoatHeadset",399));
		product.add(new Product(102,"Watch",999));
		product.add(new Product(103,"Boottle",69));
		product.add(new Product(104,"T-shirt,small",299));
		product.add(new Product(105,"Samsung j2 Phone",6599));
		product.add(new Product(106,"HairDryer",999));
	}

	public List<Product> findAll()  
	{  
	return product;  
	}
	
	public Product findOne(Long productId)  
	{  
	for(Product products:product)  
	{  
	if(products.getId()==productId)  
	return products;  
	}  
	return null;  
	}  
	
	public Product save(Product products)  
	{  
	if(products.getId()==0)  
	{   
	products.setId(++productCount);  
	}  
	product.add(products);  
	return products;  
	}  
	  
	public Product delete(Long productId)
	{
		Iterator<Product> it =product.iterator();
		while(it.hasNext())
		{
			Product delete = it.next();
			if(delete.getId()==productId)
			{
				it.remove();
				return delete; 
			}
			
		}
		return null;
	}

}
