package com.example.shopobackend.repository;

import org.springframework.stereotype.Repository;
import com.example.shopobackend.data.RolePrivilege;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RolePrivilegeRepository extends JpaRepository<RolePrivilege,Long> {
}
