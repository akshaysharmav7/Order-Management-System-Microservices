package com.clinic.orderservice.service;

import com.clinic.orderservice.dto.CreateOrderRequest;
import com.clinic.orderservice.model.Order;
import com.clinic.orderservice.model.OrderStatus;
import com.clinic.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(CreateOrderRequest request) {

        Order order = new Order();

        order.setProductId(request.productId());
        order.setQuantity(request.quantity());
        order.setStatus(OrderStatus.CREATED);

        return repository.save(order);
    }
}