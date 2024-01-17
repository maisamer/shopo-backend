package com.example.shopobackend.repository;

import com.example.shopobackend.data.Role;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    List<Role> findByRoleName(String roleName);
}
