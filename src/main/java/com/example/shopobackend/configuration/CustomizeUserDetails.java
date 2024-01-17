package com.example.shopobackend.configuration;

import com.example.shopobackend.data.ShopoUser;
import com.example.shopobackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomizeUserDetails implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<ShopoUser> users = userRepository.findByEmail(email);
        if(users.isEmpty())
            throw new UsernameNotFoundException("User not found with email: " + email);
        return new User(email,users.get(0).getPassword(), List.of());
    }
}
