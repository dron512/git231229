package com.mh.green2nd.exception;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException{

    private ErrorCode errorCode;

    public UserException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

}

