package com.clinic.orderservice.client;

import com.clinic.orderservice.dto.ProductResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class ProductClient {

    private final RestClient restClient;

    public ProductClient(RestClient.Builder builder){
        this.restClient  = builder
                .baseUrl("http://localhost:8081")
                .build();
    }

    @CircuitBreaker(
            name = "productService",
            fallbackMethod = "productServiceFallback"
    )
    @Retry(name = "productService")
    public ProductResponse getProduct(Long productId){
        return restClient
                .get()
                .uri("/products/{id}", productId)
                .retrieve()
                .body(ProductResponse.class);
    }
}