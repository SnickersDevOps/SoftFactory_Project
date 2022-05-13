package com.example.snickersdevops.controllers;


import com.example.snickersdevops.models.User;
import com.example.snickersdevops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserManagementController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    public String login(@ModelAttribute User user) {
        return "login";
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