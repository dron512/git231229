package com.mh.mychart.order;

import com.mh.mychart.order.orderitem.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {

    public static class OrderResponse{

        private Long orderId;
        private String orderName;
        private List<OrderItemDto> list = new ArrayList<>();

    }

    public static class OrderItemDto{

        private Long orderItemId;
        private String orderItemName;
        private int oderItemPrice;
    }
}
