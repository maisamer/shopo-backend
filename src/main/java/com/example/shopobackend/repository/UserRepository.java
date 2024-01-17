package com.example.shopobackend.repository;

import com.example.shopobackend.data.ShopoUser;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<ShopoUser,Long> {
    List<ShopoUser> findByEmail(String email);
}
