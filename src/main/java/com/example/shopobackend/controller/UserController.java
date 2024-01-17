package com.example.shopobackend.controller;

import com.example.shopobackend.data.ShopoUser;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.dto.UserDto;
import com.example.shopobackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public ShopoUser login(Authentication authentication) {
        return userService.login(authentication);
    }

    @PostMapping("/add")
    public ResponseModel<UserDto> saveUser(@RequestBody UserDto user){
        return userService.saveUser(user);
    }

    @GetMapping("/all")
    public List<ShopoUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/remove")
    public void removeUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

}
