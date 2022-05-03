package com.example.snickersdevops.config;


import com.example.snickersdevops.services.UserService;
import com.example.snickersdevops.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final PasswordConfig passwordConfig;
    private final UserServiceImpl userServiceImpl;


    @Autowired
    public SecurityConfig(UserService userService, PasswordConfig passwordConfig, UserServiceImpl userServiceImpl) {
        this.userService = userService;
        this.passwordConfig = passwordConfig;
        this.userServiceImpl = userServiceImpl;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] staticResources  =  {
                "/resources/**",
                "/static/**",
                "/styles/*",
                "/images/**",
                "/js/**",
                "/parts/**",
                "/login/**",
                "/registration/**"
        };

        http.authorizeRequests()
                .antMatchers(staticResources).permitAll()
                .antMatchers("/index/**").hasAnyRole("USER", "ADMIN")

                .antMatchers("/index/**").permitAll()
                .antMatchers("/oauth2/**").permitAll()
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")
                )
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .permitAll();
    }
}
