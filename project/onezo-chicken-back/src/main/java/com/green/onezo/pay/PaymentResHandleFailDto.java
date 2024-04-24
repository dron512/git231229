package com.green.onezo.pay;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResHandleFailDto {

    String errorCode;
    String errorMsg;
    String orderId;


}
