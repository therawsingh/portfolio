package com.therawsingh.portfolio.controller.tools;

import com.google.common.hash.Hashing;
import com.therawsingh.portfolio.entity.url.Url;
import com.therawsingh.portfolio.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/tools/url")
public class UrlShortenerController {

    @Autowired
    UrlRepository urlRepository;

    @GetMapping("/url")
    public String test(){
        return "url";
    }

    @CrossOrigin
    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String longUrl){


        String key = Hashing.murmur3_32_fixed().hashString(longUrl.replace("\"", ""), StandardCharsets.UTF_8).toString();

        if(urlRepository.findByShortUrl(key) != null){

            return new ResponseEntity<>("http://localhost:8080/tools/url/" + key, HttpStatus.OK);

        }

        Url url = new Url();
        url.setLongUrl(longUrl.replace("\"", ""));
        url.setShortUrl(key);
        urlRepository.save(url);

        return new ResponseEntity<>("http://localhost:8080/tools/url/" + key, HttpStatus.OK);

    }

    @CrossOrigin
    @GetMapping("/{shortUrl}")
    public RedirectView redirectToOriginalUrl(@PathVariable String shortUrl) throws URISyntaxException {

        Url url = urlRepository.findByShortUrl(shortUrl);

        RedirectView redirectView = new RedirectView();

        if(url!= null){
            redirectView.setUrl(url.getLongUrl());
        }

        else{
            redirectView.setUrl("http://localhost:8080/errorHandler/notFound");
        }
        
        return redirectView;


        //return ResponseEntity.status(HttpStatus.SEE_OTHER).location(uri).build();

        //return ResponseEntity.ok(url);

    }

}
