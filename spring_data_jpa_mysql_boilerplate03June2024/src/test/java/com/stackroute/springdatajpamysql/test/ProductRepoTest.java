package com.stackroute.springdatajpamysql.test;

import com.stackroute.springdatajpamysql.entity.Product;
import com.stackroute.springdatajpamysql.repository.ProductRepo;
import com.stackroute.springdatajpamysql.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;


public class ProductRepoTest {

    @InjectMocks
    private ProductServiceImpl productService; // Assuming you're testing the service, not the repository

    @Mock
    private ProductRepo productRepo;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        List<Product> productList = Arrays.asList(
                new Product(1L, "Product1", 10.0),
                new Product(2L, "Product2", 20.0)
        );
        when(productRepo.findAll()).thenReturn(productList);

        List<Product> result = productRepo.findAll();

        verify(productRepo, times(1)).findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void testFindById() {
        Long productId = 1L;
        Product product = new Product(productId, "Product1", 10.0);
        when(productRepo.findById(productId)).thenReturn(Optional.of(product));

        Optional<Product> result = productRepo.findById(productId);

        verify(productRepo, times(1)).findById(productId);
        assertEquals(product, result.orElse(null));
    }

    @Test
    public void testSave() {
        Product product = new Product(1L, "Product1", 10.0);
        when(productRepo.save(product)).thenReturn(product);

        Product result = productRepo.save(product);

        verify(productRepo, times(1)).save(product);
        assertEquals(product, result);
    }

    @Test
    public void testUpdateProduct() {
        Long productId = 1L;
        Product existingProduct = new Product(productId, "Product1", 10.0);
        Product updatedProduct = new Product(productId, "Updated Product", 15.0);

        // Mock the findById method to return the existingProduct when called with productId
        when(productRepo.findById(productId)).thenReturn(Optional.of(existingProduct));

        // Mock the save method to return the updatedProduct when called with any Product
        when(productRepo.save(any(Product.class))).thenReturn(updatedProduct);

        Product result = productService.updateProduct(updatedProduct, productId);

        verify(productRepo, times(1)).findById(productId);
        verify(productRepo, times(1)).save(existingProduct);
        assertEquals(updatedProduct, result);
    }


    @Test
    public void testDelete() {
        Long productId = 1L;
        doNothing().when(productRepo).deleteById(productId);

        productRepo.deleteById(productId);

        verify(productRepo, times(1)).deleteById(productId);
    }

    @Test
    public void testFindProductsLessThanPrice() {
        // Mocking data
        double price = 100.0;
        Product product1 = new Product(1L, "Product1", 90.0);
        Product product2 = new Product(2L, "Product2", 110.0);
        List<Product> productList = Arrays.asList(product1, product2);

        // Mocking the repository method
        when(productRepo.findProductsLessThanPrice(price)).thenReturn(productList);

        // Calling the service method that uses the repository method
        List<Product> result = productService.getAllProductsHavingPriceLessThan(price);

        // Verifying the result
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2); // Update this line
        // Add additional assertions based on your data

        // Verifying that the repository method was called
        verify(productRepo, times(1)).findProductsLessThanPrice(price);
    }

}

