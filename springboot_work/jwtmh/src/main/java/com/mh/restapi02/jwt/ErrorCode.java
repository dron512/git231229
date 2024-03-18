package com.mh.restapi02.jwt;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "토큰 에러", "토큰 유효기간이 끝났습니다."),
    TOKEN_VALID(HttpStatus.UNAUTHORIZED, "토큰 에러", "토큰이 유효하지 않습니다."),
    TOKEN_NOT_BEARER(HttpStatus.UNAUTHORIZED, "토큰 에러", "NOT BEARER TYPE"),

    ;

    private HttpStatus httpStatus;
    private String message;
    private String desc;

    ErrorCode(HttpStatus httpStatus, String message, String desc) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.desc = desc;
    }
}
