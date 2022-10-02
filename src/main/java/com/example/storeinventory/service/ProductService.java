package com.example.storeinventory.service;

import com.example.storeinventory.dto.ProductDto;
import com.example.storeinventory.models.Product;
import com.example.storeinventory.response.ProductResponse;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    Product findProductById(Long id);

//    Product saveProduct(ProductDto product);

    ProductResponse<Product> updateProduct(Long id , ProductDto product);

    Boolean deleteProductById(Long id);
//    Boolean deleteAllProduct(Product p);

   ProductResponse<Product> productDaoToEntity(ProductDto productDto);
}
