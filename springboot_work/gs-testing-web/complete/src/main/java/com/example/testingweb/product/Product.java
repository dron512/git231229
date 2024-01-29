package com.example.testingweb.product;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
public class Product {
    private String name;
    private int price;

    @Id
    private Long id;
}
