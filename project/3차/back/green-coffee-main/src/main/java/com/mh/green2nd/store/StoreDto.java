package com.mh.green2nd.store;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoreDto {

    private String name;
    private String address;
    private String phone;
    private String open;
    private String close;
    private String holiday;
    private String status;

    public StoreDto(Store store) {
        this.name = store.getName();
        this.address = store.getAddress();
        this.phone = store.getPhone();
        this.open = store.getOpen();
        this.close = store.getClose();
        this.holiday = store.getHoliday();
        this.status = store.getStatus();
    }
}