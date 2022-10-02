package com.example.storeinventory.service;

import com.example.storeinventory.dto.LoginDto;
import com.example.storeinventory.dto.RegistrationDto;
import com.example.storeinventory.response.ApiResponse;

public interface UserService {

    ApiResponse register(RegistrationDto registrationDto);

    ApiResponse loginUser(LoginDto loginDto);


}
