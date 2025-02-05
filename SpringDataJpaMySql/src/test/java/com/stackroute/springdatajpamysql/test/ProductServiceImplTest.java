
package com.stackroute.springdatajpamysql.test;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.repository.ProductRepo;
import com.stackroute.springdatajpamysql.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ProductServiceImplTest {

	@InjectMocks
	private ProductServiceImpl productService;

	@Mock
	private ProductRepo productRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllProducts() {
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1L, "Product1", 10.0));
		productList.add(new Product(2L, "Product2", 20.0));
		when(productRepository.findAll()).thenReturn(productList);

		List<Product> result = productService.getAllProducts();

		verify(productRepository, times(1)).findAll();
		assertEquals(2, result.size());
	}

	@Test
	public void testGetProductById() {
		Long productId = 1L;
		Product product = new Product(productId, "Product1", 10.0);
		when(productRepository.findById(productId)).thenReturn(Optional.of(product));

		Product result = productService.getProductById(productId);

		verify(productRepository, times(1)).findById(productId);
		assertNotNull(result);
		assertEquals(product, result);
	}

	@Test
	public void testSaveProduct() {
		Product product = new Product(1L, "Product1", 10.0);
		when(productRepository.save(product)).thenReturn(product);

		Product result = productService.saveProduct(product);

		verify(productRepository, times(1)).save(product);
		assertNotNull(result);
		assertEquals(product, result);
	}

	@Test
	public void testUpdateProduct() {
		Long productId = 1L;
		Product existingProduct = new Product(productId, "Product1", 10.0);
		Product updatedProduct = new Product(productId, "Updated Product", 15.0);
		when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
		when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

		Product result = productService.updateProduct(updatedProduct, productId);

		verify(productRepository, times(1)).findById(productId);
		verify(productRepository, times(1)).save(existingProduct);
		assertNotNull(result);
		assertEquals(updatedProduct, result);
	}

	@Test
	public void testDeleteProduct() {
		Long productId = 1L;
		doNothing().when(productRepository).deleteById(productId);

		String result = productService.deleteProduct(productId);

		verify(productRepository, times(1)).deleteById(productId);
		assertEquals("Product Deleted", result);
	}

	@Test public void testGetAllProductsHavingPriceLessThan() { // Mocking data
  double price = 100.0; Product product1 = new Product(1L, "Product1", 90.0);
  Product product2 = new Product(2L, "Product2", 110.0); List<Product>
  productList = Arrays.asList(product1, product2);
  
  // Mocking the repository method
  when(productRepository.findProductsLessThanPrice(price)).thenReturn(
  productList);
  
  // Calling the service method 
  List<Product> result =  productService.getAllProductsHavingPriceLessThan(price);
  
  // Verifying the result assertThat(result).isNotNull();
  assertThat(result.size()).isEqualTo(2);
  assertThat(result.get(0).getName()).isEqualTo("Product1");
  assertThat(result.get(0).getPrice()).isEqualTo(90.0);
  assertThat(result.get(1).getName()).isEqualTo("Product2");
  assertThat(result.get(1).getPrice()).isEqualTo(110.0);
  
  // Verifying that the repository method was called 
  verify(productRepository,  times(1)).findProductsLessThanPrice(price); }
}
