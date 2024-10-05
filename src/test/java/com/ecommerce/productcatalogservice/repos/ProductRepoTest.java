package com.ecommerce.productcatalogservice.repos;

import com.ecommerce.productcatalogservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    ProductRepo productRepo;

    @Test
    public void testSaveProduct() {
        Product product = new Product();
        product.setId(2L);
        product.setTitle("Test Product");
        product.setDescription("Test Description");
        product.setImageUrl("http://example.com/image.jpg");
        product.setAmount(100.0);
        product.setIsPrimeSpecific(false);
        productRepo.save(product);
        assertNotNull(product.getId());
    }
}