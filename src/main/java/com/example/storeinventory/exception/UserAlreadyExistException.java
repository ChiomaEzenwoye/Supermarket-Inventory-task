package com.example.storeinventory.exception;

import lombok.Getter;

@Getter
public class UserAlreadyExistException extends RuntimeException{
    private final String message;

    public UserAlreadyExistException(String message) {
        this.message = message;
    }
}
