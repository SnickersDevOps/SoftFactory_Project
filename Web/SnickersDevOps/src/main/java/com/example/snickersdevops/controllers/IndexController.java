package com.example.snickersdevops.controllers;

import com.example.snickersdevops.models.User;
import com.example.snickersdevops.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    private final UserRepository userRepository;

    @Autowired
    public IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/biology")
    public String BiologyCourse(){
        return "biology";
    }

    @GetMapping("/chemistry")
    public String ChemistryCourse(){
        return "chemistry";
    }

    @GetMapping("/geography")
    public String geographyCourse(){
        return "geography";
    }

    @GetMapping("/math")
    public String mathCourse(){
        return "math";
    }

    @GetMapping("/math_literacy")
    public String mathLiteracyCourse(){
        return "math_literacy";
    }

    @GetMapping("/oqu_sauat")
    public String oquSauatCourse(){
        return "oqu_sauat";
    }

    @GetMapping("/physics")
    public String physicsCourse(){
        return "physics";
    }

    @GetMapping("/qazaqstan_tarih")
    public String qazaqstanTarihCourse(){
        return "qazaqstan_tarih";
    }

    @GetMapping("/profile")
    public String profilePage(){
        return "profile";
    }

    @GetMapping("/test")
    public String testPage(){
        return "test";
    }

}
