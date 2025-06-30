package com.example.jwtdemo.controller;

import com.example.jwtdemo.model.User;
import com.example.jwtdemo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/hello")
//    public String hello(@RequestHeader("Authorization") String authHeader) {
//        String token = authHeader.replace("Bearer ", "");
//        String username = jwtService.validateToken(token);
//        if (username != null) {
//            return "Hello, " + username + "!";
//        } else {
//            return "Invalid token";
//        }
//    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Missing or invalid Authorization header");
        }

        String token = authHeader.replace("Bearer ", "");
        String username = jwtService.validateToken(token);

        if (username != null) {
            return ResponseEntity.ok("Hello, " + username + "!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
        }
    }

}