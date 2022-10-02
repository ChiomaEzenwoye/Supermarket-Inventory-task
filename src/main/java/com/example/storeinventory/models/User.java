package com.example.storeinventory.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(name ="users")
public class User extends BaseClass {

    private String name;
    private String email;
    private String password;
}
