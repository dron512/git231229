package com.mh.green2nd.cart.cartMenu;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CartMenuDto {

//    @Schema(title = "주문 ID", description = "주문 항목을 추가할 주문의 ID")
//    private String cartId;
    @Schema(title = "메뉴 ID", description = "주문 항목으로 추가할 메뉴의 ID")
    private String menuId;
    @Schema(title = "주문 수량", description = "주문할 메뉴의 수량")
    private int quantity;

    private int size;
    private int ice;
    private int shot;
    private int cream;

//    private int price_size;
//    private int price_shot;
//    private int price_cream;

    private double subCartPrice;

}
