package com.mh.green2nd.store;

import lombok.Data;

import java.util.Map;

@Data
public class OrderInfo {
    private String customerName;
    private Map<String, Integer> orderedItems;
    private double totalOrderPrice;
}