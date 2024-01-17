package com.example.shopobackend.repository;

import com.example.shopobackend.data.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
}
