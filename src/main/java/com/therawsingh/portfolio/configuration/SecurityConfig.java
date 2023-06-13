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
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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
                .csrf(AbstractHttpConfigurer::disable
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home/**")
                        .permitAll()
                        .requestMatchers("/tools/**")
                        .permitAll()
                        .requestMatchers("/todo/**")
                        .permitAll()
                        .requestMatchers("/user/**")
                        .authenticated()
                        .requestMatchers("/errorHandler/**")
                        .permitAll()
                        .requestMatchers("/errorHandler/**")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        )
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

                                OAuth2User oUser = (OAuth2User) authentication.getPrincipal();

                                System.out.println("on auth success");

                                if (oUser != null) {

                                    System.out.println("user logged in");

                                    System.out.println(userRepository.findByEmail(oUser.getAttribute("email")));

                                    if (userRepository.findByEmail(oUser.getAttribute("email")) == null) {

                                        System.out.println("user no exist");

                                        User user = new User();

                                        user.setName(oUser.getAttribute("name"));
                                        user.setEmail(oUser.getAttribute("email"));

                                        userRepository.save(user);

                                        System.out.println("user persisted");

                                    }
                                }
                            }
                        }));

        return http.build();

    }

}
