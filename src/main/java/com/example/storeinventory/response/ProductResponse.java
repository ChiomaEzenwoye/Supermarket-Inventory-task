package com.example.storeinventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse<T> {

    private String message;
    private LocalDateTime timeStamp;
    private T data;
}
