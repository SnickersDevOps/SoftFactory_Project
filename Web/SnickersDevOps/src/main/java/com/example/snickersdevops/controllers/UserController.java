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
@RequestMapping(UserController.ROOT_MAPPING)
public class UserController {

    public static final String ROOT_MAPPING = "/users";
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @GetMapping(value = "/{user_id}/quizzes")
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<Quiz> getQuizzesByUser(Pageable pageable, @PathVariable Long user_id) {
        logger.debug("Requested page " + pageable.getPageNumber() + " from user " + user_id);

        User user = userService.find(user_id);
        return quizService.findQuizzesByUser(user, pageable);
    }
}
