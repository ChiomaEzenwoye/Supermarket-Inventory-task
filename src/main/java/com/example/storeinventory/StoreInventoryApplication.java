package com.example.storeinventory;

import com.example.storeinventory.models.Product;
import com.example.storeinventory.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StoreInventoryApplication implements CommandLineRunner {


    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(StoreInventoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("bread" , "bakes" , "gfgukjjihugjgdfghi" , 9.0 , 78 ));
        productRepository.save(new Product("Cake" , "bakes" , "gfgukjjihugjgdfghi" , 9.0 , 78 ));
        productRepository.save(new Product("lettuce" , "bakes" , "gfgukjjihugjgdfghi" , 9.0 , 78 ));
        productRepository.save(new Product("Salad" , "bakes" , "gfgukjjihugjgdfghi" , 9.0 , 78 ));
        productRepository.save(new Product("Peanut Butter" , "bakes" , "gfgukjjihugjgdfghi" , 9.0 , 78 ));
    }
}
