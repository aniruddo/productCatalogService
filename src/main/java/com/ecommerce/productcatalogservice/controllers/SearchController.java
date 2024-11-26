package com.ecommerce.productcatalogservice.controllers;

import com.ecommerce.productcatalogservice.dtos.SearchProductDto;
import com.ecommerce.productcatalogservice.dtos.SortParam;
import com.ecommerce.productcatalogservice.models.Product;
import com.ecommerce.productcatalogservice.services.ISearchService;
import com.ecommerce.productcatalogservice.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private ISearchService searchService;

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchProductDto searchProductDto) {
        System.out.println("Searching...");
        return searchService.searchProducts(searchProductDto.getQuery(),searchProductDto.getPageNumber(),searchProductDto.getPageSize(),searchProductDto.getSortParams());
    }
}
