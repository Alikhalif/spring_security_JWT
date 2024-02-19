package com.youcode.reviews_jwt.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTservice {
    String generateToken(UserDetails userDetails);
    String extractUserName(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    String generateRefreshToken(Map<String, Object> extracClaims, UserDetails userDetails);
}
