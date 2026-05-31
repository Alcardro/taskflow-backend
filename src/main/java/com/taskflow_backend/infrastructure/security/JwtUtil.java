package com.taskflow_backend.infrastructure.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret:miClaveSecretaSuperSeguraParaJWT12345}")
    private String secret;

    @Value("${jwt.expiration:86400000}") // 24 horas en milisegundos
    private long expiration;

    public String generateToken(UserDetails userDetails) {
        return JWT.create()
                .withSubject(userDetails.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration))
                .sign(Algorithm.HMAC256(secret));
    }

    public String extractUsername(String token) {
        DecodedJWT decoded = JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token);
        return decoded.getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            final String username = extractUsername(token);
            return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        DecodedJWT decoded = JWT.require(Algorithm.HMAC256(secret))
                .build()
                .verify(token);
        return decoded.getExpiresAt().before(new Date());
    }
}