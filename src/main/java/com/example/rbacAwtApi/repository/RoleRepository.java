package com.example.rbacAwtApi.repository;

import com.example.rbacAwtApi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
