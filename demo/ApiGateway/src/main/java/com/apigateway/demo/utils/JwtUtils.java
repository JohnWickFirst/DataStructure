package com.apigateway.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtils {

    public static final String JWT_KEY="agbsdbvbvsdlgksldkgikwenzbhdzfhdfhedyeryeryyjit546454537edfgdfgdfgad43534wfdfsdafsd23r5423523523vfwsdvsdfgsf43245234234vb23vcadsdasdasd234234234234232vqacfacsfdsvfxsc";

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
