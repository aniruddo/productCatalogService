package com.ecommerce.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private Double amount;

    private CategoryDto category;
}
