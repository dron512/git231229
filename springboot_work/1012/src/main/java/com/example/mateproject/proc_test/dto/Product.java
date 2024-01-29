package com.example.mateproject.proc_test.dto;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int idx;
    private String name;
    private int price;
    private int quantity;
}
