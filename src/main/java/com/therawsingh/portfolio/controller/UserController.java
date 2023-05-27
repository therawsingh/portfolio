package com.therawsingh.portfolio.controller;

import com.therawsingh.portfolio.entity.user.User;
import com.therawsingh.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public String getUserDetails(OAuth2AuthenticationToken authentication) {
        OAuth2User user = authentication.getPrincipal();
        String email = user.getAttribute("email");
        String name = user.getAttribute("name");
        return name + " " + email;
    }

    @GetMapping("/username")
    public String getUserName(OAuth2AuthenticationToken authentication) {
        OAuth2User user = authentication.getPrincipal();
        String name = user.getAttribute("name");
        return name;
    }

    @GetMapping("/email")
    public String getUserEmail(OAuth2AuthenticationToken authentication) {
        OAuth2User user = authentication.getPrincipal();
        String email = user.getAttribute("email");
        return email;
    }

    @GetMapping("/addUser")
    public void addUser(OAuth2AuthenticationToken authentication){

        OAuth2User user = authentication.getPrincipal();

        String email = user.getAttribute("email");
        String name = user.getAttribute("name");

        User newUser = new User(name, email);

        userRepository.save(newUser);

        System.out.println("user persisted");

    }

}
