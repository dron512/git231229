package com.three.alcoholshoppingmall.project.shoppingbasket;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.stock.Stock;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class DetailbasketDTO {

    @JsonIgnore
    private Long number;

    @JsonIgnore
    private Long shoppingbasket;

    private Long alcoholcode;

    private String marketname;


    private int amount;

    @JsonIgnore
    private int price;

    private Delivery delivery;
}
