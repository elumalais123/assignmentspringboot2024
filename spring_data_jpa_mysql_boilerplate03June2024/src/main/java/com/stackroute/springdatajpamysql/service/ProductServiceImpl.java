package com.stackroute.springdatajpamysql.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.exceptions.ProductNotFoundException;
import com.stackroute.springdatajpamysql.repository.ProductRepo;

//Implement ProductService here
@Service
public class ProductServiceImpl  implements ProductService{
    //Override all the methods here
	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return  productRepo.findAll();
	}
	@Override
	public List<Product> getAllProductsHavingPriceLessThan(Double price) {
		// TODO Auto-generated method stub
		return productRepo.findProductsLessThanPrice(price);
	}
	@Override
	public Product getProductById(Long id)  throws ProductNotFoundException{
		// TODO Auto-generated method stub
		return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("No Product Found With ID " + id));
	}
	
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}
	
	@Override
	public Product updateProduct( Product product,Long id) {
		// TODO Auto-generated method stub
		
		Product product2=getProductById(id);
		product2.setName(product.getName());
		product2.setPrice(product.getPrice());
		return productRepo.save(product2);
	}
	
	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
		productRepo.deleteById(id);
		
		return "Product Deleted";
	}
}
