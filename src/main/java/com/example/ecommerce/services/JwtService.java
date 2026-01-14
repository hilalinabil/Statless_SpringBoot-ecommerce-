package com.example.ecommerce.services;


import com.example.ecommerce.models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtService {

    @Value("${app.jwt.secret:your-secret-key-min-256-chars-00000000000000000000000000000}")
    private String SECRET_KEY;

    @Value("${app.jwt.expiration:3600000}") // 1 hour in ms
    private long EXPIRATION_TIME;

    @Value("${app.jwt.refresh-expiration:604800000}") // 7 days in ms
    private long REFRESH_EXPIRATION_TIME;

    // generate JWT  access tokens
    public String generateAcessToken(User user)
    {
        return generateToken(User.getUsername(), User.getAuthorities, EXPIRATION_TIME);
    }

    // refresh JWT access tokens
    public String generateRefreshToken(User user)
    {
        return generateToken(User.getUsername(), User.getAuthorities, REFRESH_EXPIRATION_TIME)
    }

    // Core token logic
     private String generateToken(String username, Collection<? extends GrantedAuthority > ,long expirationTime)
     {
         Map<String, Object> claims = new HashMap<>();
         claims.put("roles", authorities.stream()
                 .map(GrantedAuthority::getAuthority).
                 collect(Collectors.toList()));
         return Jwts.builder()
                 .claims(claims)
                 .subject(username)
                 .issuedAt(new Date())
                 .expiration(new Date(System.currentTimeMillis() + expirationTime))
                 .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                 .compact();
     }
}
