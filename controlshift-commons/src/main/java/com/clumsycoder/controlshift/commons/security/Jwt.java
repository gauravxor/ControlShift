package com.clumsycoder.controlshift.commons.security;

import io.github.thibaultmeyer.cuid.CUID;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class Jwt {

    private static final String SECRET_KEY = "2e91342f4eee736b1f26b256473c3e2ab4f86a7300445a340f9e623c014e6229";
    private static final String ISSUER = "clumsycoder";
    private static final Duration TOKEN_VALIDITY = Duration.ofHours(1);

    public static SecretKey getSecretKey() {
        try {
            return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid secret key ", e);
        }
    }

    public static String getTokenId() {
        return CUID.randomCUID2().toString();
    }

    public static String issue(Map<String, Object> claims) {
        if (claims == null) {
            throw new IllegalArgumentException("Claims cannot be empty");
        }

        Instant now = Instant.now();
        Instant expiry = now.plus(TOKEN_VALIDITY);

        return Jwts.builder()
                .claims(claims)
                .id(getTokenId())
                .issuer(ISSUER)
                .issuedAt(Date.from(now))
                .expiration(Date.from(expiry))
                .signWith(getSecretKey())
                .compact();
    }

    public static Claims validate(String token) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token);
            return jws.getPayload();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JWT token", e);
        }
    }
}