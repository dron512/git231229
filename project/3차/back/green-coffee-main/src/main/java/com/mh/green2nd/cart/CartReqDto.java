package com.mh.green2nd.cart;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CartReqDto {

    private Long menuId;
    @Column(columnDefinition = "integer default 1")
    private int quantity;
//    private Long cartId;

    private int size;
    private int ice;
    private int shot;
    private int cream;

//    private int price_size;
//    private int price_shot;
//    private int price_cream;
}
