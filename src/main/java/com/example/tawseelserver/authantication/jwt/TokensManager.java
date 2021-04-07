package com.example.tawseelserver.authantication.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
@Scope("singleton")
public class TokensManager {

//
    private final String  key = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";
    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs
    final String userIdHeaderKey = "userId";
    public Integer verifyToken(String token)/*throws TokenExpiredException */ {
        Integer  userId = null;
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(key.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            JwsHeader header = claimsJws.getHeader();
            Date tokenExpiration = claimsJws.getBody().getExpiration();
            Date now = new Date();
            if (tokenExpiration.after(now)) {
                userId = (int) header.get(userIdHeaderKey);
            }
            return userId;
        } catch (Exception e) {
            System.out.println("Time out");
        }

        return userId;
    }

    public String generateToken(int userId) {
        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        int mins = 30;
        Date expirationInMines = new Date(t + (mins * ONE_MINUTE_IN_MILLIS));

        String token = Jwts
                .builder()
                .setHeaderParam(userIdHeaderKey, userId)
                .setIssuedAt(new Date())
                .setExpiration(expirationInMines)
                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                .compact();
        return token;
    }

    public HttpHeaders getTokenHeader(String token)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        return headers;
    }
}