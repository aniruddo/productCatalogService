package com.ecommerce.productcatalogservice;

import com.ecommerce.productcatalogservice.repos.ProductRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductCatalogServiceApplicationTests {

    @Autowired
    private ProductRepo productRepo;

    @Test
    @Transactional
    public void testQueries() {
        //List<Product> productList = productRepo.findProductByAmountBetween(10000D,200000D);
//        List<Product> productList = productRepo.findProductByIsPrimeSpecificTrue();
//        for(Product product : productList) {
//            System.out.println(product.getDescription()+" "+product.getIsPrimeSpecific());
//        }

        String desc = productRepo.findCategoryNameFromProductId(5000L);
        System.out.println(desc);
    }
}
