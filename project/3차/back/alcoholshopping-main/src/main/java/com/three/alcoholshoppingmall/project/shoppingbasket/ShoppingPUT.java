package com.three.alcoholshoppingmall.project.shoppingbasket;

import com.three.alcoholshoppingmall.project.purchase.Delivery;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ShoppingPUT {

    private Long id;

    private  int amount;
}
