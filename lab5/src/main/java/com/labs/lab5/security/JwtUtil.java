//package com.labs.lab5.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//
//public class JwtUtil {
//    private final String SECRET_KEY = "my_secret_key";
//
//    // generate token for a given username
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valid for 10 hours
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    // retrieve username from JWT token
//    public String extractUsername(String token) {
//        return extractClaim(token).getSubject();
//    }
//
//    // check if the token has expired
//    public boolean isTokenExpired(String token) {
//        return extractClaim(token).getExpiration().before(new Date());
//    }
//
//    // validate the token
//    public boolean validateToken(String token, String username) {
//        String tokenUsername = extractUsername(token);
//        return (tokenUsername.equals(username) && !isTokenExpired(token));
//    }
//
//    // extract claims from the token
//    private Claims extractClaim(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//}
