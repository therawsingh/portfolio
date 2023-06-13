package com.therawsingh.portfolio.controller.tools;

import com.therawsingh.portfolio.entity.oi.OiResponse;
import com.therawsingh.portfolio.entity.weather.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/tools/weather")
public class WeatherController {

    @Value("${weatherstack.api.key}")
    String apiKey;

    @GetMapping("/weather")
    public String test(){
        return "weather";
    }


    @CrossOrigin
    @GetMapping("/{location}")
    public WeatherResponse getWeather(@PathVariable String location){


        String uri = "http://api.weatherstack.com/current?access_key=" + apiKey + "&query=" + location;
        RestTemplate restTemplate = new RestTemplate();

        WeatherResponse response = restTemplate.getForObject(uri, WeatherResponse.class);

        return response;

    }

}
