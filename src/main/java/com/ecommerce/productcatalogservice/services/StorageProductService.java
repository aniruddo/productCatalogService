package com.ecommerce.productcatalogservice.services;

import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.repos.CategoryRepo;
import com.ecommerce.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ssps")
@Primary
public class StorageProductService implements IProductService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public List<Product> getAllProducts() {
              return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
}
