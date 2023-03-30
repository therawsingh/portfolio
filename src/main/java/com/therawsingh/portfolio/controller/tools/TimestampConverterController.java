package com.therawsingh.portfolio.controller.tools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools/ts")
public class TimestampConverterController {

    @GetMapping("/ts")
    public String test(){
        return "ts";
    }

}
