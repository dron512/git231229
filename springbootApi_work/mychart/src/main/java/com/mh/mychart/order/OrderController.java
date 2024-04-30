package com.mh.mychart.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/api/order/new")
    public void newOrder() {
        System.out.println("new order");
    }
}
