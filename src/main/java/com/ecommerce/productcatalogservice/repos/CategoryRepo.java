package com.ecommerce.productcatalogservice.repos;

import com.ecommerce.productcatalogservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}