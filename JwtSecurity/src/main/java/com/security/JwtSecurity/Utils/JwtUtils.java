package com.security.JwtSecurity.Utils;

import com.security.JwtSecurity.Repository.UserRepo;
import io.jsonwebtoken.io.Decoders;
import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import io.jsonwebtoken.security.Keys;


import static com.security.JwtSecurity.Constant.SecurityConstant.JWT_KEY;

@Service
public class JwtUtils {
    @Autowired
    private UserRepo userRepo;

    public String extractUserName(String token){

        return null;
    }
    public String generateToken(String userName) {
        Map<String,Object> claim= new HashMap<>();
        return this.createToken(claim,userName);
    }

    public String createToken(Map<String,Object> claim, String subject){

        SecretKey key = Keys.hmacShaKeyFor(JWT_KEY.getBytes(StandardCharsets.UTF_8));

        String jwt = Jwts.builder().setIssuer("Eazy Bank").setSubject("JWT Token")
                .claim("username", subject)
                .claim("authorities", "USER")
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + 300000000))
                .signWith(getSignKey()).compact();
        return jwt;
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_KEY).parseClaimsJws(token);
            return true;
        }catch (Exception e){
           return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Date extractClaim(String token, Object getExpiration) {
        return extractClaim(token, Claims::getExpiration);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(JWT_KEY).parseClaimsJws(token).getBody();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
}
