package com.mh.restapi05.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object>
            handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                         HttpHeaders headers,
                                         HttpStatusCode status,
                                         WebRequest request) {
        System.out.println("일로오나");
        ErrorResponse response = ErrorResponse.builder()
                .message("잘못된 요청입니다."+ex.getBindingResult().getFieldErrors())
                .reason("유효성 검사 실패"+ex.getBindingResult().getFieldError().getDefaultMessage())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
