package com.example.creatorstore.controllers;

import com.example.creatorstore.dto.OrderRequest;
import com.example.creatorstore.entities.Order;
import com.example.creatorstore.services.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(
            @Valid @RequestBody OrderRequest orderRequest,
            Authentication authentication
    ) {
        return orderService.createOrder(
                orderRequest,
                authentication.getName()
        );
    }

    @GetMapping
    public Page<Order> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Authentication authentication
    ) {
        return orderService.getAllOrders(
                page,
                size,
                authentication.getName()
        );
    }

    @GetMapping("/{id}")
    public Order getOrderById(
            @PathVariable Long id,
            Authentication authentication
    ) {
        return orderService.getOrderById(
                id,
                authentication.getName()
        );
    }
}
