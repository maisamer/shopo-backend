package com.example.shopobackend.dto;

import com.example.shopobackend.enums.UserStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    private String username;
    private String password;
    @JsonProperty("role")
    private String roleName;
    private UserStatus status;
    private String mobileNumber;
}
