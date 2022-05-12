package com.example.snickersdevops.services;

import com.example.snickersdevops.dto.UserRegistrationDto;
import com.example.snickersdevops.exсeptions.ResourceUnavailableException;
import com.example.snickersdevops.models.Role;
import com.example.snickersdevops.models.User;
import com.example.snickersdevops.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public Page<User> findAllBySearch(String searchTerm, Pageable pageable) {
        //TODO implement this method
        return null;
    }

    @Override
    public User find(Long id) throws ResourceUnavailableException {
        if (id == null)
            return null;
        User user = userRepository.findById(id)
                .orElseGet(null);

        if (user == null) {
            logger.error("The user " + id + " can't be found");
            throw new ResourceUnavailableException("User " + id + " not found.");
        }

        return user;
    }

    @Override
    public User findByEmail(String email) throws ResourceUnavailableException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            logger.error("The mail " + email + " can't be found");
            throw new ResourceUnavailableException("The mail " + email + " can't be found");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("INVALID USERNAME OR PASSWORD");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map( role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

}
