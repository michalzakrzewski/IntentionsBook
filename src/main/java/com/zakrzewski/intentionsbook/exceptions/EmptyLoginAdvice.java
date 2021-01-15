package com.zakrzewski.intentionsbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmptyLoginAdvice {

    @ResponseBody
    @ExceptionHandler(EmptyLoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emptyLoginHandler(EmptyLoginException exception){
        return exception.getMessage();
    }
}
