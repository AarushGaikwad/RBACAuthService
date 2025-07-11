package com.example.rbacAwtApi.controller;

import com.example.rbacAwtApi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> creds){

        String token = authService.login(creds.get("username"), creds.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }
}
