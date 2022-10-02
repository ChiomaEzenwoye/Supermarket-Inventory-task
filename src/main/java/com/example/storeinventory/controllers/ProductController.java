package com.example.storeinventory.controllers;

import com.example.storeinventory.dto.ProductDto;
import com.example.storeinventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping(value = "/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto product) {
        return new ResponseEntity<>(productService.productDaoToEntity(product), HttpStatus.CREATED);
    }


    @GetMapping("/getAllProduct")
    public ResponseEntity<?> allProduct(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }


    @PostMapping(value = "/editProduct/{id}")
    public ResponseEntity<?> adminEditProduct(@PathVariable(value = "id") Long id, @RequestBody ProductDto product){
        return new ResponseEntity<>(productService.updateProduct(id , product), HttpStatus.OK);
    }


    @PostMapping(value = "/deleteProduct/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
        return new ResponseEntity<>(productService.deleteProductById(productId), HttpStatus.OK);
    }



    @GetMapping(value = "/getProduct/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable(name="productId") String productId){
        Long id = Long.parseLong(productId);
        return new ResponseEntity<>(productService.findProductById(id), HttpStatus.FOUND);
    }


}