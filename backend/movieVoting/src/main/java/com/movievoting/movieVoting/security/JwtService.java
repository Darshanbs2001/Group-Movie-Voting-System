package com.movievoting.movieVoting.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
@Component
public class JwtService {
    @Value("${security.jwt.key}")
    private String secret;// "92E0A6159E8E651BBC1B1866ABC13C25218B717B623A4C3293A8384C99F13F6F4310EF916D4D2EF1F1F69278EEC6109D44BABF04267FC8A2778E3C99362A3506";
    private final static long validity = TimeUnit.MINUTES.toMillis(30);

    public String extract(String jwt) {
        // TODO Auto-generated method stub
        return this.getClaims(jwt).getSubject();


    }


    public String generateToken(UserDetails userdetails) {
        Map<String, String> claims =new HashMap<>();
        claims.put("iss", "https://secure.darshancoder.com");
        claims.put("name","bros");

        return Jwts.builder()
                .subject(userdetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(validity)))
                .claims(claims)
                .signWith(getKey())
                .compact();
    }

    public Claims getClaims(String jwt) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

    private SecretKey getKey() {
        byte[] keys = Base64.getDecoder().decode(secret);

        return Keys.hmacShaKeyFor(keys);

    }

    public boolean validate(String jwt) {
        // TODO Auto-generated method stub
        return getClaims(jwt).getExpiration().after(Date.from(Instant.now()));
    }
}
