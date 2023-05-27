package com.therawsingh.portfolio.service;

import com.therawsingh.portfolio.entity.user.User;
import com.therawsingh.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        System.out.println("in load user");

        OAuth2User oUser = super.loadUser(userRequest);
        User user = new User(oUser.getAttribute("name"), oUser.getAttribute("email"));

        System.out.println("user object created");

        userRepository.save(user);

        System.out.println("user data persisted");

        return oUser;
    }
}
