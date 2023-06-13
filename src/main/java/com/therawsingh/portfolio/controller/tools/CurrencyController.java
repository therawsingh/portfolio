package com.therawsingh.portfolio.controller.tools;

import com.therawsingh.portfolio.entity.currency.CurrencyResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/tools/currency")
public class CurrencyController {

    @CrossOrigin
    @GetMapping("/to={to}&from={from}&amount={amount}")
    public CurrencyResponse convert(@PathVariable String to, @PathVariable String from, @PathVariable String amount){

        String uri = "https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount;

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("apikey", "af8SPFluT7wjaDP2GX5KZlWwoyy9ur9O");

        HttpEntity<String> entity = new HttpEntity<String>("body", headers);

        ResponseEntity<CurrencyResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, CurrencyResponse.class);

        CurrencyResponse currencyResponse = response.getBody();

        return currencyResponse;

    }

}
