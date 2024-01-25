package com.example.shopobackend.repository;

import com.example.shopobackend.data.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.user u WHERE u.email = :userEmail")
    List<Order> findAllOrdersByUserEmail(String userEmail);
}
