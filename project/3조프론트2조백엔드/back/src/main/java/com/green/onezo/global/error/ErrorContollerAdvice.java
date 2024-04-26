package com.green.onezo.global.error;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorContollerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        System.out.println("일로오냐");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request Body가 잘못되었습니다.");
    }

    // 프론트에서 보내는 데이터가 잘못된 경우
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        java.util.List<FieldError> list = ex.getFieldErrors();
        String errorMessage = "";

        for (FieldError error : list) {
            errorMessage += error.getDefaultMessage() + "\n";
        }

        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .errorMessage( errorMessage )
                .errorDateTime(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
