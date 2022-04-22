package com.example.snickersdevops.services;

import com.example.snickersdevops.dto.UserRegistrationDto;
import com.example.snickersdevops.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);
}
