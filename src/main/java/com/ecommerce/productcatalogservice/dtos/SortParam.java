package com.ecommerce.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParam {
    private String attribute;
    private SortType sortType;
}
