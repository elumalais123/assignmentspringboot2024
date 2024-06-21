package com.stackroute.springdatajpamysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.springdatajpamysql.entity.Product;

//Create ProductRepo interface extending JpaRepository
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	@Query("select p from Product p where p.price < :price")
	List<Product> findProductsLessThanPrice(Double price);
}
