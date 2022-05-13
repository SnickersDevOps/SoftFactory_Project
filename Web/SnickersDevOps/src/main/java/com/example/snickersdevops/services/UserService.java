package com.example.snickersdevops.services;

import com.example.snickersdevops.dto.UserRegistrationDto;
import com.example.snickersdevops.exсeptions.ResourceUnavailableException;
import com.example.snickersdevops.exсeptions.UnauthorizedActionException;
import com.example.snickersdevops.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto userRegistrationDto);

    Page<User> findAllBySearch(String searchTerm, Pageable pageable);

    User find(Long id) throws ResourceUnavailableException;

    void delete(Long user_id) throws UnauthorizedActionException, ResourceUnavailableException;

    User findByEmail(String email) throws ResourceUnavailableException;
}
