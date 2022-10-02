package com.example.storeinventory.serviceImpl;

import com.example.storeinventory.dto.RegistrationDto;
import com.example.storeinventory.exception.UserAlreadyExistException;
import com.example.storeinventory.models.User;
import com.example.storeinventory.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    private LocalDateTime localDateTime;
    private User user;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;


    @BeforeEach
    void setUp() {
        localDateTime = LocalDateTime.now();
        user = new User("chioma","chioma@gmail.com","1234");
        when(userRepository.save(user)).thenReturn(user);

    }

    @Test
    void registerUser() {
        RegistrationDto userDto = new RegistrationDto("chioma", "chioma@gmail.com", "1234");
        when(userRepository.findUserByEmail(userDto.getEmail())).thenReturn(Optional.empty());
        var actual = userService.register(userDto);
        assertEquals("Success", actual.getMessage());

    }

    @Test
    void registerAlreadyExistingUser() {
        RegistrationDto userDto = new RegistrationDto("chioma", "chioma@gmail.com","1234");
        when(userRepository.findUserByEmail(userDto.getEmail())).thenReturn(Optional.of(user));
        assertThrows(UserAlreadyExistException.class, () -> userService.register(userDto));

    }

}