package com.hotel.HotelBooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http

            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                        "/",
                        "/home",
                        "/about",
                        "/gallery",
                        "/contact",
                        "/blog",
                        "/properties",
                        "/login",
                        "/register",
                        "/forgot",

                        "/assets/**",
                        "/assetTP/**",
                        "/css/**",
                        "/js/**",
                        "/images/**"
                )

                .permitAll()

                .anyRequest()

                .permitAll()
            )

            .formLogin(form -> form.disable())

            .logout(logout -> logout.disable());

        return http.build();
    }
}