package com.mh.restapi03.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    DUPLICATE(HttpStatus.BAD_REQUEST,"DUPLICATE","중복된 내용이 있습니다."),
    NOTFOUND(HttpStatus.NOT_FOUND,"NOTFOUND","해당해는 내용이없습니다."),
    TEST(HttpStatus.BAD_GATEWAY,"TEST","TEST입니다."),
    NOTUPDATEEMAIL(HttpStatus.NOT_FOUND,"NOTUPDATE","수정할이메일이없습니다."),
    lOGINFAILED(HttpStatus.UNAUTHORIZED,"lOGINFAILED","이메일 패스워드 확인하세요")
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
