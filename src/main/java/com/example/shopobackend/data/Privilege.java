package com.example.shopobackend.data;

import lombok.Data;
import jakarta.persistence.Entity;

@Data
@Entity
public class Privilege extends BaseEntity{
    private String privilegeName;
}
