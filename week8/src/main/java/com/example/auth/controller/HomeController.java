package com.example.auth.controller;

import com.example.auth.infra.AuthenticationFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final AuthenticationFacade authFacade;

    public HomeController(AuthenticationFacade authFacade) {
        this.authFacade = authFacade;
    }

    @GetMapping
    public String home(){
        try {
//            logger.info("user{}", principal.getName());
//            logger.info("user{}", authentication.getName());
//            logger.info("new user{}",
//                    SecurityContextHolder.getContext().getAuthentication().getName());
            logger.info("new user{}",authFacade.getUserName());
        } catch (NullPointerException e){
            logger.info("no user loogerd in");
        }
        return "index";
    }
}
