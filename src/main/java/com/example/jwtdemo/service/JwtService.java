package com.example.jwtdemo.service;

import com.example.jwtdemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;

    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "password".equals(password);
    }

    public String generateToken(String username) {
        return jwtUtil.generateToken(username);
    }

    public String validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
}