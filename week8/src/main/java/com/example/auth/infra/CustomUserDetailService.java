package com.example.auth.infra;

import com.example.auth.entity.UserEntity;
import com.example.auth.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        final UserEntity test = new UserEntity();
        test.setUsername("entity_user");
        test.setPassword(passwordEncoder.encode("test1pass"));
        this.userRepository.save(test);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByUsername(username);
        return new User(username,userEntity.getPassword(), new ArrayList<>());
    }
}
