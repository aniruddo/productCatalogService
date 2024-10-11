package com.ecommerce.productcatalogservice.repos;

import com.ecommerce.productcatalogservice.models.Category;
import com.ecommerce.productcatalogservice.models.Product;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

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

    @Test
    @Transactional
    public void runSubQueries() {
        List<Category> cats = categoryRepo.findAll();
        for(Category category : cats) {
            for(Product product :  category.getProducts()) {
                System.out.println(product.getDescription());
            }
        }
    }

}