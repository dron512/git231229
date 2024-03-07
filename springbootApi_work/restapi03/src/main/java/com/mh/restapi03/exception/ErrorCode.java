package com.mh.restapi03.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    DUPLICATE(HttpStatus.BAD_REQUEST,"A001","중복된 내용이 있습니다."),
    NOTFOUND(HttpStatus.NOT_FOUND,"B001","내용이없습니다."),
    TEST(HttpStatus.BAD_GATEWAY,"C001","TEST입니다.")
    ;

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
