package com.wenso.codesegment.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Object customException(Exception e) {
        System.out.println("Exception");
        e.printStackTrace();
        return null;
    }

    @ExceptionHandler(RuntimeException.class)
    public Object customException(RuntimeException e) {
        System.out.println("RuntimeException");
        e.printStackTrace();
        return null;
    }
}
