package com.example.shopobackend.repository;

import com.example.shopobackend.data.ShopoUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<ShopoUser,Long> {
    Optional<ShopoUser> findByEmail(String username);
}
