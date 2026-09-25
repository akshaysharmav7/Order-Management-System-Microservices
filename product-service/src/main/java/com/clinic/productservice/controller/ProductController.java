package com.clinic.productservice.controller;

import com.clinic.productservice.model.Product;
import com.clinic.productservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) throws InterruptedException {
        System.out.println("Fetching product: " + id);
        Thread.sleep(10000);
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }
}