package com.codecool.apigateway.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtTokenUtil {

    @Value("${jwt.expiration.minutes}")
    private int jwtExpirationMinutes;

//    @Value("${security.jwt.token.secret-key:secret}")
    private String key = "thisIsALongerKeyWorkPlease";

    private Key secretKey;

    @PostConstruct
    protected void init() {
        byte[] encodedKey = Base64.getEncoder().encode(key.getBytes());
        this.secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "HmacSHA512");
    }

//    @PostConstruct
//    private void initKey() {
//        secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//    }

    public UsernamePasswordAuthenticationToken validateTokenAndExtractUserSpringToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
        ArrayList<String> rolesList = claims.get("roles", ArrayList.class);
        List<SimpleGrantedAuthority> roles =
                rolesList.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(
                claims.getSubject(),
                null,
                roles);
    }

    public String generateToken(Authentication authentication) {
        List<String> roles = authentication
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("roles", roles)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * jwtExpirationMinutes))
                .signWith(secretKey)
                .compact();
    }
}
