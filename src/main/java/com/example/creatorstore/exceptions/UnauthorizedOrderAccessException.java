package com.example.creatorstore.exceptions;

public class UnauthorizedOrderAccessException
        extends RuntimeException {

    public UnauthorizedOrderAccessException() {
        super("You are not authorized to view this order");
    }
}