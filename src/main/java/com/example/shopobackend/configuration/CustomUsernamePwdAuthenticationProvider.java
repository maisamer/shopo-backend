package com.example.shopobackend.configuration;
import com.example.shopobackend.data.Privilege;
import com.example.shopobackend.data.ShopoUser;
import com.example.shopobackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<ShopoUser> userOptional = userRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            ShopoUser user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return new UsernamePasswordAuthenticationToken(email, password,
                        getGrantedAuthorities(user.getRole().getPrivileges()));
            }
        }
        throw new BadCredentialsException("Email or password not correct");

    }

    private List<GrantedAuthority> getGrantedAuthorities(List<Privilege> privileges) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Privilege privilege : privileges) {
            grantedAuthorities.add(new SimpleGrantedAuthority(privilege.getPrivilegeName()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
