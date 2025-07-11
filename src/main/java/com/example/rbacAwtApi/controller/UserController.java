package com.example.rbacAwtApi.controller;

import com.example.rbacAwtApi.entity.User;
import com.example.rbacAwtApi.repository.RoleRepository;
import com.example.rbacAwtApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder encoder;
    private final RoleRepository roleRepository;

    @PostMapping("/users")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body){
        User user = new User();
        user.setUsername(body.get("username"));
        user.setPassword(encoder.encode(body.get("password")));
        user.getRoles().add(roleRepository.findById("USER").orElseThrow());
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> adminPage(){
        return ResponseEntity.ok("Welcome Admin");
    }
}
