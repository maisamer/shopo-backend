package com.example.shopobackend.dto;

import com.example.shopobackend.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String username;
    private String password;
    @JsonProperty("role")
    private String roleName;
    private UserStatus status;
    private String mobileNumber;
}
