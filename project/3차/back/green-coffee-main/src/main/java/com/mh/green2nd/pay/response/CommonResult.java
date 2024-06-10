package com.mh.green2nd.pay.response;

import lombok.Data;

@Data
public class CommonResult {
    private Boolean Success;
    private int code;
    private String msg;
}
