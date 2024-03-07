package com.mh.restapi02.jwt;

import lombok.Getter;

@Getter
public enum ErrorCode {
    
    Error101("토큰 에러","유효하지 않은 토큰")
    ;

    private String message;
    private String desc;

    ErrorCode(String message, String desc) {
        this.message = message;
        this.desc = desc;
    }
}
