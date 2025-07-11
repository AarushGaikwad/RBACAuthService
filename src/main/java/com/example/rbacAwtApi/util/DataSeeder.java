package com.example.rbacAwtApi.util;

import com.example.rbacAwtApi.entity.Role;
import com.example.rbacAwtApi.entity.User;
import com.example.rbacAwtApi.repository.RoleRepository;
import com.example.rbacAwtApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final RoleRepository roleRepo;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public void run(String... args){
        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        roleRepo.saveAll(List.of(admin, user));

        User adminUser = new User(null, "admin", encoder.encode("admin123"), Set.of(admin));
        User regularUser = new User(null, "user", encoder.encode("user123"), Set.of(user));
    }


}
