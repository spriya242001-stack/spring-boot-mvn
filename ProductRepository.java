package com.example.productcatalog.repository;

import com.example.productcatalog.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // 1. Added explicit import for Java's List collection

@Repository
// 2. Removed the generic <List> tag from the interface definition line
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    // 3. Correctly uses List to hold a collection of ProductEntity objects
    List<ProductEntity> findByCategory(String category);
}