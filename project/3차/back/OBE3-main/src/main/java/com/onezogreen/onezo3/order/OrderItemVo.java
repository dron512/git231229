package com.onezogreen.onezo3.order;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemVo {
    private Long orderItemId;
    private Long orderId;
    private Long menuId;
    private int quantity;
    private int price;
    private String menuName;
}
