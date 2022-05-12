package com.example.snickersdevops.controllers;

import com.example.snickersdevops.models.User;
import com.example.snickersdevops.repository.UserRepository;
import com.example.snickersdevops.services.UserService;
import com.example.snickersdevops.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public String profilePage(Model model, Principal principal){

        String email = principal.getName();
        User user = userService.findByEmail(email);

        model.addAttribute("user", user);
        return "profile";
    }

//    @GetMapping("/profile/{id}")
//    public String showUserData(@PathVariable("id") Long id, Model model) {
//        User user = userRepository.getUsersById(id);
//        model.addAttribute("user", user);
//        return "profile";
//    }
}
