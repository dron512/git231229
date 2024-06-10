package com.mh.green2nd.orders.adminOrder;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminOrderResDto {

        private String name;
        private String address;
        private String phone;
        private String open;
        private String close;
        private String holiday;
        private String status;

        private double totalOrderPrice;
        private LocalDateTime orderTime;
}
