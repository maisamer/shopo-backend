package com.example.shopobackend.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RolePrivilege extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;

}

