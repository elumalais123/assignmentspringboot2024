package com.stackroute.springdatajpamysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.service.ProductService;

import jakarta.websocket.server.PathParam;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> products=productService.getAllProducts();
		return new ResponseEntity<>(products,HttpStatus.OK); 
	}
	@GetMapping("/productsby/{price}")
	public ResponseEntity<List<Product>> getAllProductsHavingPriceLessThan(@PathVariable("price") Double price){
		List<Product> products=productService.getAllProductsHavingPriceLessThan(price);
				
		return new ResponseEntity<>(products,HttpStatus.OK); 
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
		Product response = productService.getProductById(id);
				
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
	@PostMapping("/products/saveProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product response = productService.saveProduct(product);
				
		return new ResponseEntity<Product>(response,HttpStatus.OK); 
	}
	@PutMapping("/products/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("id") Long id){
		Product response = productService.updateProduct( product,id);
				
		return new ResponseEntity<Product>(response,HttpStatus.OK); 
	}
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		String response = productService.deleteProduct(id);
				
		return new ResponseEntity<>(response,HttpStatus.OK); 
	}
	
	
}
