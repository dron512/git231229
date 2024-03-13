package com.mh.restapi03.exception;


import lombok.Getter;

@Getter
public class LogicException extends RuntimeException{

    private ErrorCode errorCode;

    public LogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
