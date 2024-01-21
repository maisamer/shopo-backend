package com.example.shopobackend.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Privilege extends BaseEntity{
    private String privilegeName;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}
