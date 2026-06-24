package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/public/**").permitAll()
	            .requestMatchers("/professors/**").hasRole("PROFESSOR")
	            .requestMatchers("/students/**").hasRole("STUDENT")
	            .requestMatchers("/exams/*/students").hasAnyRole("STUDENT", "PROFESSOR")
	            .anyRequest().authenticated()
	        )
	        .httpBasic(Customizer.withDefaults())
	        .logout(logout -> logout
	            .logoutUrl("/api/logout")
	            .logoutSuccessHandler((req, res, auth) -> {
	                res.setStatus(200);
	            })
	        );

	    return http.build();
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}