package com.stackroute.springdatajpamysql.service;

import java.util.List;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.exceptions.ProductNotFoundException;

//Create service interface here

public interface ProductService {
  //Add abstract methods here
	List<Product> getAllProducts();
	List<Product> getAllProductsHavingPriceLessThan(Double price);
	Product getProductById(Long id) throws ProductNotFoundException;
	Product saveProduct(Product product);
	Product updateProduct(Product product,Long id);
	String deleteProduct(Long id); 
}
