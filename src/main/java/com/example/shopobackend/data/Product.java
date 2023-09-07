package com.example.shopobackend.data;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
