package com.zakrzewski.intentionsbook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ChurchWorkerAdvice {

    @ResponseBody
    @ExceptionHandler(ChurchWorkerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String churchWorkerExceptionHandler(ChurchWorkerException exception){
        return exception.getMessage();
    }
}
