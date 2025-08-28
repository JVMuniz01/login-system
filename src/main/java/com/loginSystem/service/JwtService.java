package com.loginSystem.service;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private static final String SECRET_KEY = "segredo_super_secreto_32_chars_minimo!!";
	private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(java.nio.charset.StandardCharsets.UTF_8));
	
	public String generateToken(String email) {
	    return Jwts.builder()
	            .setSubject(email)
	            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
	            .signWith(key, SignatureAlgorithm.HS256)
	            .compact();
	}
	public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
