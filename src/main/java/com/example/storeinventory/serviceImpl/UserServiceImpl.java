package com.example.storeinventory.serviceImpl;

import com.example.storeinventory.dto.LoginDto;
import com.example.storeinventory.dto.RegistrationDto;
import com.example.storeinventory.exception.UserAlreadyExistException;
import com.example.storeinventory.exception.UserNotFoundException;
import com.example.storeinventory.models.User;
import com.example.storeinventory.repository.UserRepository;
import com.example.storeinventory.response.ApiResponse;
import com.example.storeinventory.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ApiResponse register(RegistrationDto registrationDto) {
        Optional<User> existingUser = userRepository.findUserByEmail(registrationDto.getEmail());
        if (existingUser.isEmpty()) {
            User user = new User();
            user.setName(registrationDto.getName());
            user.setEmail(registrationDto.getEmail());
            user.setPassword(registrationDto.getPassword());
            userRepository.save(user);
            return new ApiResponse("Success", LocalDateTime.now());
        }else{
            throw new UserAlreadyExistException("Email Already Exist");
        }


    }

    @Override
    public ApiResponse loginUser(LoginDto loginDto) {
        var user = userRepository.findUserByEmail(loginDto.getEmail()).orElseThrow(()-> new UserNotFoundException("User not found"));
        if(user.getPassword().equalsIgnoreCase(loginDto.getPassword())){
            return new ApiResponse("Success", LocalDateTime.now());
        }else {
            throw new UserNotFoundException("Password Mismatch");
        }

    }


}