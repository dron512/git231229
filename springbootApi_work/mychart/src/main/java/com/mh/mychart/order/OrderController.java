package com.mh.mychart.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getorder/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable long orderId) {
        Optional<Order> order = orderService.getOrder(orderId);
        if(order.isPresent())
            return ResponseEntity.ok().body(order.get());
        return ResponseEntity.notFound().build();
    }
}
