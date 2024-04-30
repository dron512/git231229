package com.mh.mychart.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void newOrder() {
        System.out.println("new order");
    }

    public Optional<Order> getOrder() {
        System.out.println("get order");
        return orderRepository.findById(8l);
    }

}
