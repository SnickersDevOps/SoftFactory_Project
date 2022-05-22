package com.example.snickersdevops.controllers;

import com.example.snickersdevops.models.*;
import com.example.snickersdevops.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class WebUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{user_id}/quizzes", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    public String getQuizzesForUser(@PathVariable Long user_id) {
        userService.find(user_id);

        // TODO: Unimplemented
        return "error";
    }

    @RequestMapping(value = "/quizzes", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public String getQuizzesForAuthenticatedUser() {
        return "myQuizzes";
    }
}