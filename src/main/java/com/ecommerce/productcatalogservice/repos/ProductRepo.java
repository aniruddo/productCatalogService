package com.ecommerce.productcatalogservice.repos;

import com.ecommerce.productcatalogservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Page<Product> findProductByTitleContains(String query, Pageable pageable);
    @Query("SELECT p.description from Product p where p.id=?1")
    String findProductDesciptionFromProductId(Long id);

    List<Product> findProductByAmountBetween(Double low, Double high);

    //List<Product> findProductByIsPrimeSpecific(Boolean value);
    List<Product>  findProductByIsPrimeSpecificTrue();

    @Query("SELECT c.name from Category c join Product p on p.category.id=c.id where p.id=:productId")
    String findCategoryNameFromProductId(Long productId);

    Optional<Product> findById(Long id);
}