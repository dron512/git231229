package com.three.alcoholshoppingmall.project.shoppingbasket;

import com.three.alcoholshoppingmall.project.purchase.Delivery;
import com.three.alcoholshoppingmall.project.stock.Stock;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@Data
@Builder
public class Shopping {

    private Long id;
    private Long stock;

    private String name;

    private Long alcoholcode;

    private String marketname;

    private String marketaddress;

    private  int amount;

    private int price;

    private String picture;

    private Delivery delivery;

}
