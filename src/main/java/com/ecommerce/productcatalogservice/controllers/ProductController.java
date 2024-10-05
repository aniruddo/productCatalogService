package com.ecommerce.productcatalogservice.controllers;

import com.ecommerce.productcatalogservice.dtos.CategoryDto;
import com.ecommerce.productcatalogservice.dtos.ProductDto;
import com.ecommerce.productcatalogservice.models.Category;
import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService iProductService;

//    public ProductController(IProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        List<Product> products = iProductService.getAllProducts();
        List<ProductDto> productDtos = new ArrayList<>();
        if(products!=null && !products.isEmpty()) {
            for(Product product : products) {
                ProductDto productDto = from(product);
                productDtos.add(productDto);
            }
            return productDtos;
        }
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId)
    {
        try {
            if (productId < 1) {
                throw new RuntimeException("Product not found");
            }
            Product product = iProductService.getProductById(productId);
            if (product == null) return null;
            return new ResponseEntity<>(from(product), HttpStatus.OK);
        }catch (RuntimeException exception) {
            //return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            throw exception;
        }
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        Product product = from(productDto);
        Product response = iProductService.createProduct(product);
        return from(response);
    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        Product product = iProductService.replaceProduct(id,from(productDto));
        return from(product);
    }


    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setAmount(productDto.getAmount());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            category.setDescription(productDto.getCategory().getDescription());
            product.setCategory(category);
        }
        return product;
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setAmount(product.getAmount());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }

        return productDto;
    }

//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<String> handleExceptions(Exception exception) {
//        return new ResponseEntity<>("kuch toh phata hai", HttpStatus.BAD_REQUEST);
//    }

}
