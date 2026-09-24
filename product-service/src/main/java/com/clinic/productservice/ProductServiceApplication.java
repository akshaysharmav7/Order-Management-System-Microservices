package com.clinic.productservice;

import com.clinic.productservice.model.Product;
import com.clinic.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner seedProducts(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Product product = new Product();
                product.setName("Mechanical Keyboard");
                product.setPrice(new BigDecimal("2500"));
                product.setStock(100);

                repository.save(product);
            }
        };
    }
}
