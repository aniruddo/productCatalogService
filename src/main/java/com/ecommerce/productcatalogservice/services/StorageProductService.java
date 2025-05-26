package com.ecommerce.productcatalogservice.services;

import com.ecommerce.productcatalogservice.dtos.RoleDto;
import com.ecommerce.productcatalogservice.dtos.UserDto;
import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.repos.CategoryRepo;
import com.ecommerce.productcatalogservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service("ssps")
@Primary
public class StorageProductService implements IProductService {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    RestTemplate restTemplate;
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

    @Override
    public Product getProductBasedOnUserRole(Long productId, Long userId) {
        Product product = productRepo.findById(productId).get();
        UserDto userDto = restTemplate.getForEntity("http://userservice/users/{userId}", UserDto.class,userId).getBody();
        RoleDto admin = new RoleDto();
        admin.setName("ADMIN");
        if(userDto != null && userDto.getRoles().contains(admin)) {
            return product;
        }
        return null;
    }
}
