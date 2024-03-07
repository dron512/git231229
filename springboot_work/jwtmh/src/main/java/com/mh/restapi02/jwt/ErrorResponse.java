package com.mh.restapi02.jwt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {

    public static ResponseEntity<String> createErrorMessage(ErrorCode code)
    {
        return
            ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(String.format("[ %s %s]",code.getMessage(),code.getDesc()));
    }
}
