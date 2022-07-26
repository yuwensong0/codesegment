package com.wenso.codesegment.web.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @RequestMapping("/hello")
    public String hello() {
        throw new RuntimeException("hello");
    }
}
