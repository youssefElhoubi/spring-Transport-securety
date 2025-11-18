package com.transportsecure.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    @Value("${security.jwt.expiration}")
    private String JWT_SECRET;
    @Value("${security.jwt.secret-key}")
    private String JWT_expiration;

    public String createToken(String userId, Map<String, Object> claims) {
        return Jwts.builder().
                setClaims(claims).
                setSubject(userId)
                .setExpiration(new Date(System.currentTimeMillis()+JWT_expiration))
                .setIssuedAt(new Date())
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public Object getClaims(String claim, String token) {
        return extractAllClaims(token).get(claim);
    }

    public String getSubject(String token) {
        return extractAllClaims(token).get("subject").toString();
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = extractAllClaims(token);
            return claims.getExpiration().before(new Date());

        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractAllClaims(String token){
        return  Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSecretKey(){
        byte[] bytes = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(bytes);
    }

}
