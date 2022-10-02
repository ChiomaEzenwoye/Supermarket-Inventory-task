package com.example.storeinventory.controllers;

import com.example.storeinventory.exception.ProductResourceException;
import com.example.storeinventory.exception.UserAlreadyExistException;
import com.example.storeinventory.exception.UserNotFoundException;
import com.example.storeinventory.response.ExceptionResponse;
import com.example.storeinventory.utils.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionController {
    private final ResponseService<ExceptionResponse> responseService;

//this class manages the exceptions and allows the user to see only customize messgaes.
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> userAlreadyExistHandler(UserAlreadyExistException existException){
        return responseService.response(new ExceptionResponse(existException.getMessage(), LocalDateTime.now(), HttpStatus.CONFLICT),HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> userNotFoundHandler(UserNotFoundException exception){
        return responseService.response(new ExceptionResponse(exception.getMessage(), LocalDateTime.now(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductResourceException.class)
    public ResponseEntity<ExceptionResponse> productResourceHandler(ProductResourceException exception){
        return responseService.response(new ExceptionResponse(exception.getMessage(), LocalDateTime.now(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }


}
