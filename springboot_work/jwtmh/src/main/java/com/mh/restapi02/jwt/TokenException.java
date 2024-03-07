package com.mh.restapi02.jwt;

import lombok.Getter;

@Getter
public class TokenException extends RuntimeException{
    private ErrorCode errorCode;
    public TokenException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
