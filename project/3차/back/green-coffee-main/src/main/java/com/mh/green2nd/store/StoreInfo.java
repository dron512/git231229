package com.mh.green2nd.store;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class StoreInfo {

    private String name;
    private String address;
    private String phone;
    private String open;
    private String close;
    private String holiday;
    private String status;
    private String admin_name;
    private List<OrderInfo> orderInfos;

    private Map<LocalDate, Double> salesInfo;
    private LocalDateTime create_date;

    public StoreInfo(String name, String address, String phone, String open, String close, String holiday, String status, String admin_name, Map<LocalDate, Double> salesInfo, LocalDateTime create_date) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.open = open;
        this.close = close;
        this.holiday = holiday;
        this.status = status;
        this.admin_name = admin_name;
        this.salesInfo = salesInfo;
        this.create_date = create_date;
    }

}