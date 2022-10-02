package com.example.storeinventory.exception;

import lombok.Getter;

@Getter
public class ProductResourceException extends RuntimeException {
    private final String message;

    public ProductResourceException(String message) {
        this.message = message;
    }
}
