package com.mh.mychart.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("new")
    public void newOrder() {
        System.out.println("new order");
    }

    @GetMapping("getOrder")
    public ResponseEntity<Order> getOrder() {
        Optional<Order> order = orderService.getOrder();
        if(order.isPresent())
            return ResponseEntity.ok().body(order.get());
        return ResponseEntity.notFound().build();
    }
}
