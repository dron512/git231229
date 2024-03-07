package com.mh.restapi03.users;

import com.mh.restapi03.exception.ErrorResponse;
import com.mh.restapi03.exception.LogException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LogException.class)
    public final ResponseEntity<ErrorResponse> hanleLogException(LogException ex){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(ex.getErrorCode().getErrorCode())
                .errorMessage(ex.getErrorCode().getMessage())
                .errorDateTime(LocalDateTime.now())
                .build();
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(errorResponse);
    }

}
