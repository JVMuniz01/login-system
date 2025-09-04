package com.loginSystem.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // desabilita CSRF
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/h2-console/**").permitAll() // libera H2 Console
	            .anyRequest().permitAll()  // continua permitindo todas as rotas
	        )
	        .headers(headers -> headers
	            .frameOptions(frame -> frame.sameOrigin()) // permite iframe no mesmo domínio
	        );

	    return http.build();
	}
	
	@Bean			//Por algum motivo o h2 funcionou depois disso
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
}
