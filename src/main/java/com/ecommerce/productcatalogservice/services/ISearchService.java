package com.ecommerce.productcatalogservice.services;

import com.ecommerce.productcatalogservice.dtos.SortParam;
import com.ecommerce.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {
    public Page<Product> searchProducts(String query, Integer pageNumber, Integer pageSize, List<SortParam> sortParams);
}
