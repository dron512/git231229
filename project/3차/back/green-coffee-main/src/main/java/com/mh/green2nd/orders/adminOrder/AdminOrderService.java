package com.mh.green2nd.orders.adminOrder;

import com.mh.green2nd.orders.Order;
import com.mh.green2nd.orders.OrderRepository;
import com.mh.green2nd.orders.OrderState;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminOrderService {

    private final OrderRepository orderRepository;

    // 주문 상태 변경
    public void updateOrderState(User user, Long orderId, OrderState newState) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update order state");
        }

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setState(newState);
        orderRepository.save(order);
    }

    // 주문 내역 조회
    public List<Order> getAllOrders(User user) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can get all orders");
        }

        return orderRepository.findAll();
    }

    // 모든 주문 상세 정보 조회
    public List<Order> getAllOrderDetails(User user) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can get all order details");
        }

        return orderRepository.findAll();
    }
}