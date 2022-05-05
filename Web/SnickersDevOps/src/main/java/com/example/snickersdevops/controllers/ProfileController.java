package com.example.snickersdevops.controllers;

import com.example.snickersdevops.models.User;
import com.example.snickersdevops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final UserRepository userRepository;

    @Autowired
    public ProfileController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{id}")
    public String showUserData(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUsersById(id);
        model.addAttribute("user", user);
        return "profile";
    }
}
