package com.crscube.student.global.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class TokenProvider {

    private Key key;
    private final String secretKey = "secretKey12345678AnyText43crscubeSecretKey123456789ABCDEFGHJK"; // 이후 환경변수로 이전 필요

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken() {
        Date date = new Date();

        return Jwts.builder()
                .setSubject("student")
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + 25920000000L))
                .signWith(this.key, SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(this.key).build().parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            System.out.println("JWT 만료" + e);
        } catch (Exception e) {
            System.out.println("JWT 서명 오류" + e);
        }

        return false;
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(this.key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
