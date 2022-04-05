package com.example.auth.config;

import com.example.auth.infra.CustomUserDetailService;
import com.example.auth.infra.NaverOAuth2Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final NaverOAuth2Service naverOAuth2Service;

    public WebSecurityConfig(UserDetailsService userDetailsService, NaverOAuth2Service naverOAuth2Service) {
        this.userDetailsService = userDetailsService;
        this.naverOAuth2Service = naverOAuth2Service;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);
//        auth.inMemoryAuthentication()
//                .withUser("user1")
//                .password(passwordEncoder().encode("user1pass"))
//                .roles("USER")
//                .and()
//                .withUser("admin1")
//                .password(passwordEncoder().encode("admin1pass"))
//                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .antMatchers("/home/**","/user/signup/**")
                    .anonymous()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin()
                    .loginPage("/user/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(this.naverOAuth2Service)
                    .and()
                    .defaultSuccessUrl("/home")
                .and()
                    .logout()
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/home")
                    .deleteCookies("JSEESIONID")
                    .invalidateHttpSession(true)
                    .permitAll();

    }

}
