package com.therawsingh.portfolio.controller.tools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools/pdf")
public class PdfController {

    @GetMapping("/pdf")
    public String test(){
        return "pdf";
    }

}
