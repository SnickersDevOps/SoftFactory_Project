package com.example.snickersdevops.controllers;

import com.example.snickersdevops.dto.UserRegistrationDto;
import com.example.snickersdevops.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);

        return "redirect:/registration?success";
    }
}
