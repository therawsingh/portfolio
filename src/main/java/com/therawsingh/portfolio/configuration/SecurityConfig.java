package com.therawsingh.portfolio.configuration;

import com.therawsingh.portfolio.entity.user.User;
import com.therawsingh.portfolio.repository.UserRepository;
import com.therawsingh.portfolio.service.CustomOAuth2UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private CustomOAuth2UserService customOAuth2UserService;

    @Autowired
    private UserRepository userRepository;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/home/**")
                .permitAll()
                //.authenticated()
                .requestMatchers("/tools/**")
                .permitAll()
                //.authenticated()
                .requestMatchers("/todo/**")
                .permitAll()
                .requestMatchers("/user/**")
                //.permitAll()
                .authenticated()
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .and()
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

                        OAuth2User oUser = (OAuth2User) authentication.getPrincipal();

                        if(oUser != null){
                            if(userRepository.findByEmail(oUser.getAttribute("email")) != null){

                                User user = new User();

                                user.setName(oUser.getAttribute("name"));
                                user.setEmail(oUser.getAttribute("email"));

                                userRepository.save(user);
                            }
                        }
                    }
                })
                ;

        return http.build();

    }

}
