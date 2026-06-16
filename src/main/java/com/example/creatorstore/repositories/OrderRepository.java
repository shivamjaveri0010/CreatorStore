package com.example.creatorstore.repositories;

import com.example.creatorstore.entities.Order;
import com.example.creatorstore.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    Page<Order> findByUser(
            User user,
            Pageable pageable
    );
}