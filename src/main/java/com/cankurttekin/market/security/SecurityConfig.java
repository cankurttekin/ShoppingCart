package com.cankurttekin.market.security;

import com.cankurttekin.market.application.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                authorize
//                                .requestMatchers(HttpMethod.GET, "/api/products").hasRole("EMPLOYEE")
//                                .requestMatchers(HttpMethod.GET, "/api/products/**").hasRole("EMPLOYEE")
//                                .requestMatchers(HttpMethod.POST, "/api/products").hasRole("MANAGER")
//                                .requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("MANAGER")
//                                .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
        );
    }
}
