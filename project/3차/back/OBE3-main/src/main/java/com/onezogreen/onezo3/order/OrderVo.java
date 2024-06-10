package com.onezogreen.onezo3.order;

import com.onezogreen.onezo3.sales.TakeInOut;
import lombok.*;


import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVo {
    private Long orderId;
    private Long storeId;
    private Long memberId;
    private OrderStatus status;
    private Timestamp orderDate;
    private TakeInOut takeInOut;
    private List<OrderItemVo> orderItems;
    private int totalPrice;

}
