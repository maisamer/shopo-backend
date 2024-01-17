package com.example.shopobackend.data;

import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
public class Role extends BaseEntity{

    private String roleName;

}

