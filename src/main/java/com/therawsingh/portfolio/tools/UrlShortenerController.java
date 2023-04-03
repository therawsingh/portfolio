package com.therawsingh.portfolio.tools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tools")
public class UrlShortenerController {

    @GetMapping("/url")
    public String test(){
        return "url";
    }

}
