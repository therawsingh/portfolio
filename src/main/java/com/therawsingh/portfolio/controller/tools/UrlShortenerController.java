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

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String longUrl){

        String key = Hashing.murmur3_32_fixed().hashString(longUrl, StandardCharsets.UTF_8).toString();

        if(urlRepository.findByShortUrl(key) != null){

            return new ResponseEntity<>("http://localhost:8080/tools/url/" + key, HttpStatus.OK);

        }

        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setShortUrl(key);
        urlRepository.save(url);

        return new ResponseEntity<>("http://localhost:8080/tools/url/" + key, HttpStatus.OK);

    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity redirectToOriginalUrl(@PathVariable String shortUrl) {

        Url url = urlRepository.findByShortUrl(shortUrl);

        return ResponseEntity.ok(url);

    }

}
