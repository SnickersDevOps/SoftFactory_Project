package com.example.snickersdevops.controllers;


import com.example.snickersdevops.models.User;
import com.example.snickersdevops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "/index";
    }

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated()")
    public String getAdminPage(Model model) {
        return "admin";
    }

    @PostMapping("/createUser")
    @PreAuthorize("permitAll")
    public String createUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        this.userRepository.deleteById(id);
        return "redirect:/admin";
    }
}