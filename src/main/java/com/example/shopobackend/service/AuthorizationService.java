package com.example.shopobackend.service;

import com.example.shopobackend.data.Role;
import com.example.shopobackend.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {
    private final RoleRepository roleRepository;

    public Role getRoleByRoleName(String roleName){
        List<Role> roles = roleRepository.findByRoleName(roleName);
        if(roles.isEmpty())
            throw new RuntimeException("there is no role with this name");
        return roleRepository.findByRoleName(roleName).get(0);
    }
}
