package org.example.studyspringbootsecurity.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> AllException(Exception ex, WebRequest webRequest){
        ex.printStackTrace();
        return  new ResponseEntity<>("AllException", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
