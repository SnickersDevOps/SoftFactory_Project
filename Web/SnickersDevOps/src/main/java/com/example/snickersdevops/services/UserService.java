package com.example.snickersdevops.services;

import com.example.snickersdevops.DTO.UserRegistrationDto;
import com.example.snickersdevops.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
