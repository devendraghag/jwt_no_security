package com.example.jwtdemo.controller;

import com.example.jwtdemo.model.User;
import com.example.jwtdemo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (jwtService.authenticate(user.getUsername(), user.getPassword())) {
            return jwtService.generateToken(user.getUsername());
        }
        return "Invalid credentials";
    }

    @GetMapping("/hello")
    public String hello(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        String username = jwtService.validateToken(token);
        if (username != null) {
            return "Hello, " + username + "!";
        } else {
            return "Invalid token";
        }
    }
}