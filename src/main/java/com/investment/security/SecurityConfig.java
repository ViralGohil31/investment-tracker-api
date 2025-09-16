package com.investment.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final JwtDecoder jwtDecoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/v1/investments/**").authenticated() // require auth
                    .anyRequest().denyAll()
            ).oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt-> jwt.decoder(jwtDecoder))); // enable JWT validation
        return http.build();
    }
}

