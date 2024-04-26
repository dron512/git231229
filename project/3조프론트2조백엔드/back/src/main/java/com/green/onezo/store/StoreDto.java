package com.green.onezo.store;

import lombok.Builder;


import java.time.LocalTime;

@Builder
public class StoreDto {
    private Long id;
    private String storeName;
    private String address;
    private String storePhone;
    private LocalTime openTime;
    private LocalTime closeTime;
    private StoreStatus storeStatus;

}
