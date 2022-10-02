package com.example.storeinventory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseClass{
    private String name;

    private String description;
    private String category;
    private double price;
    private int quantity;


}
