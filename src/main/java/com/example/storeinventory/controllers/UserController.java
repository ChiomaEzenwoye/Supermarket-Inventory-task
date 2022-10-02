package com.example.storeinventory.controllers;

import com.example.storeinventory.dto.LoginDto;
import com.example.storeinventory.dto.RegistrationDto;
import com.example.storeinventory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")

public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDto registrationDto) {
        return new ResponseEntity<>(userService.register(registrationDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(userService.loginUser(loginDto), HttpStatus.ACCEPTED);
    }
}
