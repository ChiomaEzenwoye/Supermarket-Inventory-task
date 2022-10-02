package com.example.storeinventory.serviceImpl;

import com.example.storeinventory.dto.ProductDto;
import com.example.storeinventory.models.Product;
import com.example.storeinventory.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    private LocalDateTime localDateTime;

    private Product product;


    @BeforeEach
    void setUp() {
        localDateTime = LocalDateTime.now();
        product = new Product("Milo","For energy","Beverage",1200.0,70);
        when(productRepository.save(product)).thenReturn(product);

    }

    @Test
    void productDaoToEntity() {
        ProductDto productDto = new ProductDto("Milo","For energy","Beverage",1200.0,70);
        when(productRepository.save(product)).thenReturn(product);
        var actual = productService. productDaoToEntity(productDto);
        assertEquals("Success", actual.getMessage());

    }
}