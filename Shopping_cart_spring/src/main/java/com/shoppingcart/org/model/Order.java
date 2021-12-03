package com.shoppingcart.org.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
		@Id
		@GeneratedValue
		private int orderid;
		private int quantity;
		private long total;
		@OneToMany(mappedBy = "orders")
		private List<Products> products;
		
		
		
		public int getOrderid() {
			return orderid;
		}
		public void setOrderid(int orderid) {
			this.orderid = orderid;
		}
		public List<Products> getProducts() {
			return products;
		}
		public void setProducts(List<Products> products) {
			this.products = products;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public long getTotal() {
			return total;
		}
		public void setTotal(long total) {
			this.total = total;
		}
		
		
		
}
