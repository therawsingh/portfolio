package com.therawsingh.portfolio.controller.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.therawsingh.portfolio.entity.currency.CurrencyResponse;
import com.therawsingh.portfolio.entity.oi.OiResponse;

import jakarta.security.auth.message.callback.SecretKeyCallback;
import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/getoi2")
    public Response getOi2()throws Exception{

        //String uri = "https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY";

        OkHttpClient client = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();

        Request request = new Request.Builder()
                .url("https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY")
                .addHeader("User-Agent", "Chrome/111.0.5563.147")
                .build();

        Response response = client.newCall(request).execute();
        String jsonData = response.body().string();

        JsonNode rootNode = objectMapper.readTree(jsonData);
        JsonNode filteredNode = rootNode.get("filtered");

        String result = objectMapper.writeValueAsString(filteredNode);

        return objectMapper.treeToValue(filteredNode, Response.class);

        //return result;

    }

    @GetMapping("/getoi3")
    public OiResponse getOi3()throws Exception{

        String uri = "https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Chrome/111.0.5563.147");

        HttpEntity<String> entity = new HttpEntity<String>("body", headers);

        ResponseEntity<OiResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, OiResponse.class);

        OiResponse oiResponse = response.getBody();

        return oiResponse;

    }

    @GetMapping("/oi")
    public String oi(){

        return "oi";

    }

}
