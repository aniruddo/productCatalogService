package com.ecommerce.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDto {
    private String email;
    private Set<RoleDto> roles = new HashSet<>();
}
