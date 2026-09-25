package com.clinic.orderservice.service;

import com.clinic.orderservice.client.ProductClient;
import com.clinic.orderservice.dto.CreateOrderRequest;
import com.clinic.orderservice.dto.ProductResponse;
import com.clinic.orderservice.model.Order;
import com.clinic.orderservice.model.OrderStatus;
import com.clinic.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final ProductClient productClient;

    public OrderService(
            OrderRepository repository,
            ProductClient productClient) {
        this.repository = repository;
        this.productClient = productClient;
    }

    public Order createOrder(CreateOrderRequest request) {

        ProductResponse product = productClient.getProduct(request.productId());
        if(product.stock()<request.quantity()){
            throw new RuntimeException("Insufficient Stock");
        }

        Order order = new Order();
        order.setProductId(product.id());
        order.setQuantity(request.quantity());
        order.setStatus(OrderStatus.CREATED);

        return repository.save(order);
    }
}