package com.example.storeinventory.serviceImpl;

import com.example.storeinventory.dto.ProductDto;
import com.example.storeinventory.exception.ProductResourceException;
import com.example.storeinventory.models.Product;
import com.example.storeinventory.repository.ProductRepository;
import com.example.storeinventory.response.ProductResponse;
import com.example.storeinventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ProductResourceException("Product not found"));
    }


    @Override
    public ProductResponse<Product> updateProduct(Long id , ProductDto product) {
        Product productToUpdate = findProductById(id);
        productToUpdate.setName(product.getName());
        productToUpdate.setCategory(product.getCategory());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        productToUpdate.setQuantity(product.getQuantity());

        productRepository.save(productToUpdate);
        return new ProductResponse<>("Success", LocalDateTime.now(), productToUpdate);
    }

    @Override
    public Boolean deleteProductById(Long id) {
        if(this.findProductById(id) == null){
            return false;
        }
        productRepository.deleteById(id);
        return true ;
    }

    @Override
    public ProductResponse<Product> productDaoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName()); // receives a product and sets it to the class that interacts  withpersistent layer
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());
         productRepository.save(product);
        return new ProductResponse<>("Success", LocalDateTime.now(), product);
    }
}
