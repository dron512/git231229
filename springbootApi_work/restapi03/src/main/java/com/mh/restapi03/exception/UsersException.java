package com.mh.restapi03.exception;

import lombok.Getter;

@Getter
public class UsersException extends RuntimeException{
    private ErrorCode errorCode;

    public UsersException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
