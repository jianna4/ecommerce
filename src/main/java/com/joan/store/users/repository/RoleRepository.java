package com.joan.store.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joan.store.users.entity.Role;

public interface RoleRepository extends JpaRepository <Role, Long> {
    Optional<Role> findByName(String name);
    
}
