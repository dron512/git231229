package com.onezogreen.onezo3.exception;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@ToString
public enum ErrorCode {

    //
    NOTSELECT(HttpStatus.NOT_FOUND,"NOTSELECT","조회할 내용이 없습니다."),
    INSERTFAIL(HttpStatus.BAD_REQUEST,"INSERTFAIL","등록에 실패했습니다."),
    UPDATEFAIL(HttpStatus.BAD_REQUEST,"UPDATEFAIL","수정에 실패했습니다."),
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
