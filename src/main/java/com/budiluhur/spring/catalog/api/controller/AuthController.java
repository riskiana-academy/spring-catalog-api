package com.budiluhur.spring.catalog.api.controller;

import com.budiluhur.spring.catalog.api.config.JwtUtils;
import com.budiluhur.spring.catalog.api.dto.AuthResponse;
import com.budiluhur.spring.catalog.api.dto.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtils jwtUtils;

    public AuthController(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        // Hardcode autentikasi sederhana untuk latihan lab pemula
        if ("admin".equals(request.getUsername()) && "password123".equals(request.getPassword())) {
            String token = jwtUtils.generateToken(request.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).body(null);
    }
}
