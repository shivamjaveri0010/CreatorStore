package com.example.creatorstore.controllers;

import com.example.creatorstore.dto.OrderRequest;
import com.example.creatorstore.entities.Order;
import com.example.creatorstore.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return  orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return  orderService.getOrderById(id);
    }
}
