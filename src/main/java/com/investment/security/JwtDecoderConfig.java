package com.investment.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jwt.*;

import java.util.List;

@Configuration
public class JwtDecoderConfig {

    @Bean
    public JwtDecoder customJwtDecoder() {
        NimbusJwtDecoder decoder = NimbusJwtDecoder
                .withJwkSetUri("http://localhost:8080/realms/investment-app/protocol/openid-connect/certs")
                .build();

        // Default validations (exp, nbf, iss, aud)
        OAuth2TokenValidator<Jwt> withIssuer = JwtValidators.createDefaultWithIssuer("http://localhost:8080/realms/investment-app");

        // Combine validators
        OAuth2TokenValidator<Jwt> validator = new DelegatingOAuth2TokenValidator<>(withIssuer);

        decoder.setJwtValidator(validator);
        return decoder;
    }
}
