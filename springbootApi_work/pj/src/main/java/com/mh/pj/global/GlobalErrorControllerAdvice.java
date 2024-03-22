package com.mh.pj.global;

import com.mh.pj.jwt.ErrorResponse;
import com.mh.pj.jwt.TokenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TokenException.class)
    public final ResponseEntity<ErrorResponse> handleAllException(TokenException ex){
        log.info("Token Error.....");
        ErrorResponse errorResponse = ErrorResponse.of(ex.getErrorCode());
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(errorResponse);
    }
}
