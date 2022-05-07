package com.github.javamultiplex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @author Rohit Agarwal on 07/05/22 2:32 PM
 * @copyright github.com/javamultiplex
 */

@Configuration
public class SecurityConfig {

    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService() {
        final UserDetails userDetails = User.withUsername("rohit")
                .password(passwordEncoder().encode("12345"))
                .authorities("read")
                .build();

        return new MapReactiveUserDetailsService(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity
                .httpBasic()
                .and()
                .authorizeExchange()
                .pathMatchers("/demo/**").authenticated()
                .anyExchange().permitAll()
                .and()
                .build();
    }
}
