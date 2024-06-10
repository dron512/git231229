package com.onezogreen.onezo3.order;

import com.onezogreen.onezo3.menu.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;


    public List<OrderVo> getOrdersByStore(Long storeId) {
        List<OrderVo> orders = orderMapper.getOrdersByStore(storeId);
        for (OrderVo order : orders) {
            List<OrderItemVo> orderItems = orderMapper.getOrderItemsWithMenuNamesByOrderId(order.getOrderId());
            order.setOrderItems(orderItems);
        }
        return orders;
    }

    public List<OrderVo> getOrdersByStatus(Long storeId, OrderStatus status) {
        List<OrderVo> orders = orderMapper.getOrdersByStatus(storeId, status);
        for (OrderVo order : orders) {
            List<OrderItemVo> orderItems = orderMapper.getOrderItemsWithMenuNamesByOrderId(order.getOrderId());
            order.setOrderItems(orderItems);
        }
        return orders;
    }


    public boolean acceptOrder(Long storeId, Long orderId) {
        int updatedRows = orderMapper.updateOrderStatus(storeId, orderId, OrderStatus.COOKING);
        return updatedRows > 0;
    }

    public boolean rejectOrder(Long storeId, Long orderId) {
        int updatedRows = orderMapper.updateOrderStatus(storeId, orderId, OrderStatus.REJECTED);
        return updatedRows > 0;
    }

    public boolean completeOrder(Long storeId, Long orderId) {
        int updatedRows = orderMapper.updateOrderStatus(storeId, orderId, OrderStatus.COMPLETED);
        return updatedRows > 0;
    }

    public boolean cancelOrder(Long storeId, Long orderId) {
        int updatedRows = orderMapper.updateOrderStatus(storeId, orderId, OrderStatus.CANCELLED);
        return updatedRows > 0;
    }
}
