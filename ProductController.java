package com.example.productcatalog.controller;

import com.example.productcatalog.entity.ProductEntity;
import com.example.productcatalog.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService service;

    // Dependency Injection via constructor
    public ProductController(ProductService service) {
        this.service = service;
    }

    // 1. Home Page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // 2. Show the Registration Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("productObj", new ProductEntity());
        return "addProduct";
    }

    // 3. Process Form Submission
    @PostMapping("/save")
    public String save(@ModelAttribute("productObj") ProductEntity product) {
        service.saveProduct(product);
        return "redirect:/display"; // Successfully routes to your catalog view
    }

    // 4. View All Products
    @GetMapping("/display")
    public String showCatalog(Model model) {
        // FIXED: Using the lowercase instance variable 'service' instead of the class name
        model.addAttribute("products", service.getAllProducts());
        return "displayProduct";
    }
}