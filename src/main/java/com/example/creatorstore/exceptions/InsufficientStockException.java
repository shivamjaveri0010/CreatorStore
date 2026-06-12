package com.example.creatorstore.exceptions;

public class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(Long productId){
        super("Insufficient stock for product id " + productId);
    }
}
