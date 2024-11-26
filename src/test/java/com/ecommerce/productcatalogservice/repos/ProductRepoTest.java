package com.ecommerce.productcatalogservice.repos;

import com.ecommerce.productcatalogservice.models.Category;
import com.ecommerce.productcatalogservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductRepoTest {
    @MockBean
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;


    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setId(15L);
        product.setTitle("Test Product");
        product.setDescription("Test Description");
        product.setImageUrl("http://example.com/image.jpg");
        product.setAmount(100.0);
        product.setIsPrimeSpecific(false);
        categoryRepo.findById(1L).ifPresent(product::setCategory);
        when(productRepo.save(product)).thenReturn(product);
        Product savedProduct = productRepo.save(product);
        assertEquals(product, savedProduct);
    }



}