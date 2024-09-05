package com.example.user_management_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configuring CSRF
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF (if required)
                // Configuring HTTP Basic Authentication
                .httpBasic(Customizer.withDefaults())   // Using the recommended alternative
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Only ADMIN role can access /admin/**
                        .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") // USER and ADMIN roles can access /user/**
                        .anyRequest().authenticated()    // All other requests need to be authenticated
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Setting up in-memory authentication with roles
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}adminpass")  // {noop} prefix is used for plain text passwords
                .roles("ADMIN")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}userpass")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

