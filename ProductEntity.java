package com.example.productcatalog.entity;

import jakarta.persistence.*;
@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private double price;
    private String category;
    // Default constructor (required by JPA)
    public ProductEntity() {
    }

    // Parameterized constructor (convenient for manual object creation)
    public ProductEntity(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}