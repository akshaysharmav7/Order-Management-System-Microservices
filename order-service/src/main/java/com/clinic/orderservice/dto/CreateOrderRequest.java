package com.clinic.orderservice.dto;

public record CreateOrderRequest(
        Long productId,
        Integer quantity
) {
}