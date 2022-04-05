package com.example.auth.controller;

import com.example.auth.dto.UserDto;
import com.example.auth.entity.UserEntity;
import com.example.auth.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("signup")
    public  String signup(){
        return "signup-form";
    }

    @PostMapping("signup")
    public String  signupPost(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("password_check") String passwordCheck
    ){
        if (!password.equals(passwordCheck)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        UserEntity newuseer = new UserEntity();
        newuseer.setUsername(username);
        newuseer.setPassword(passwordEncoder.encode(password));
        userRepository.save(newuseer);
        return "redirect:/home";
    }
}
