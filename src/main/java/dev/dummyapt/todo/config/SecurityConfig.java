package dev.dummyapt.todo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${oauth2.jwk-set-uri}")
    private String jwkSetUri;

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.oauth2ResourceServer(resourceServerConfigurer -> resourceServerConfigurer.jwt(jwtConfigurer -> jwtConfigurer.jwkSetUri(jwkSetUri))).csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(requests -> requests.anyRequest().authenticated()).build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
