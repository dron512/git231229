package com.mh.restapi03.exception;


import lombok.Getter;

@Getter
public class LogException extends RuntimeException{

    private ErrorCode errorCode;

    public LogException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
