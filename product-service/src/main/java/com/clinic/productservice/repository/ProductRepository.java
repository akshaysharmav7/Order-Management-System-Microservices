package com.clinic.productservice.repository;

import com.clinic.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
}