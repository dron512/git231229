package com.onezogreen.onezo3.sales;

import lombok.*;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleVo {
    private Long saleId;
    private Long storeId;
    private Long orderId;
    private Long menuId;
    private int amount;
    private Timestamp saleDate;
    private TakeInOut takeInOut;


    public String getSaleDateFormatted() {
        return saleDate.toLocalDateTime().toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}