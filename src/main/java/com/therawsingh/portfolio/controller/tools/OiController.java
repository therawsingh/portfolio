package com.therawsingh.portfolio.controller.tools;

import com.therawsingh.portfolio.entity.oi.OiResponse;
import jakarta.security.auth.message.callback.SecretKeyCallback;
import org.apache.catalina.connector.Request;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/tools/oi")
public class OiController {

    @GetMapping("/getoi")
    public OiResponse getOi(){

        String uri = "https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY";
        RestTemplate restTemplate = new RestTemplate();

        OiResponse response = restTemplate.getForObject(uri, OiResponse.class);

        return response;

    }

    @GetMapping("/oi")
    public String oi(){

        return "oi";

    }

}
