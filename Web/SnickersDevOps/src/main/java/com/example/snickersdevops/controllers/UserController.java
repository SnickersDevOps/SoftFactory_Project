package com.example.snickersdevops.controllers;

import com.example.snickersdevops.models.*;
import com.example.snickersdevops.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    public String login(@ModelAttribute User user) {
        return "login";
    }

}
