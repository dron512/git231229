package com.green.onezo.pay;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayRes {
    private String payType;
    private Long amount;
    private String orderId;
    private String orderName;
    private String ID;
    private String customerName;
    private String successUrl;
    private String failUrl;
    private LocalDateTime createDate;
    private Boolean paySuccessYn;



}
