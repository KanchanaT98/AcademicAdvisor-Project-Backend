package com.project.AcademicAdvisor.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Disable CSRF if not needed (be cautious in production)
                .authorizeRequests()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/api/register/**")).permitAll() // Allow public access to registration
                .anyRequest().authenticated() // Require authentication for all other endpoints
                .and()
                .httpBasic(); // Optional: Enable basic authentication

        return http.build();
    }
}
