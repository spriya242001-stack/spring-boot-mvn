package com.example.productcatalog.service;


import com.example.productcatalog.entity.ProductEntity;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void saveProduct(ProductEntity product) {
        repository.save(product);
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }
}