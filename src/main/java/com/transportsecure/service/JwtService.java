package com.transportsecure.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.secret-key}")
    private String JWT_SECRET;

    @Value("${security.jwt.expiration}")
    private Long JWT_expiration;

    /**
     * Creates a signed JWT token using HMAC512 algorithm.
     */
    public String createToken(String userId, Map<String, Object> claims) {
        return JWT.create()
                .withSubject(userId)
                .withPayload(claims)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_expiration))
                .sign(getAlgorithm());
    }

    /**
     * Validates the token signature and expiration.
     * If verify() succeeds, the token is valid.
     * If it throws an exception (like TokenExpiredException), it returns false.
     */
    public boolean validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(getAlgorithm()).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    public String extractUsername(String token) {
        return decodeToken(token).getSubject();
    }

    public String extractRole(String token) {
        // Extracts the "role" claim as a String. Returns null if missing.
        return decodeToken(token).getClaim("role").asString();
    }

    // Helper to decode the token without verifying logic repetition
    private DecodedJWT decodeToken(String token) {
        JWTVerifier verifier = JWT.require(getAlgorithm()).build();
        return verifier.verify(token);
    }

    // Helper to get the Algorithm with the secret key
    private Algorithm getAlgorithm() {
        // Use Java standard Base64 decoder instead of JJWT's Decoders
        byte[] keyBytes = Base64.getDecoder().decode(JWT_SECRET);
        return Algorithm.HMAC512(keyBytes);
    }
}