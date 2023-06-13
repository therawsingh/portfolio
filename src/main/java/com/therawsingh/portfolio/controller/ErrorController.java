package com.therawsingh.portfolio.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/errorHandler")
@ControllerAdvice
public class ErrorController {

    @GetMapping("/notFound")
    public String error(){
        return "Resource not found";
    }

}
