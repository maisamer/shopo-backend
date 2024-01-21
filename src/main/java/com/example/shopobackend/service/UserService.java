package com.example.shopobackend.service;

import com.example.shopobackend.Constant;
import com.example.shopobackend.data.ShopoUser;
import com.example.shopobackend.dto.ResponseModel;
import com.example.shopobackend.dto.UserDto;
import com.example.shopobackend.mappers.UserMapper;
import com.example.shopobackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final AuthorizationService authorizationService;

    public ResponseModel<UserDto> saveUser(UserDto user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            ShopoUser shopoUser = userMapper.userDtoToShopoUser(user);
            shopoUser.setRole(authorizationService.getRoleByRoleName(user.getRoleName()));
            ShopoUser insertedUser = userRepository.save(shopoUser);
            return new ResponseModel<>(HttpStatus.CREATED.value(),
                    Constant.USER_SAVED_MESSAGE,Constant.USER_SAVED_MESSAGE,userMapper.shopoUserToUserDto(insertedUser));
        } catch (Exception e) {
            return new ResponseModel<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constant.USER_NOT_SAVED_MESSAGE,e.getMessage(),null);
        }
    }

    public List<ShopoUser> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public ShopoUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserDto login(Authentication authentication) {
        Optional<ShopoUser> user = userRepository.findByEmail(authentication.getName());
        if(user.isPresent())
            return userMapper.shopoUserToUserDto(user.get());
        throw new RuntimeException("User not found");
    }

    public Optional<ShopoUser> getUserWithPrivileges(String username) {
        return userRepository.findByEmail(username);
    }
}
