package com.example.snickersdevops.controllers;

import com.example.snickersdevops.repository.UserRepository;
import com.example.snickersdevops.services.UserService;
import com.example.snickersdevops.services.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    private final UserRepository userRepository;

    private final UserService userService;

    public IndexController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
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

//    @GetMapping("/admin")
//    public String adminPage(){
//        return "admin";
//    }

    @GetMapping(value = "/quizList")
    @PreAuthorize("permitAll")
    public String getQuizList(@RequestParam(value = "name", required = false) String name, Model model,
                              @PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
                                      @SortDefault(sort = "name", direction = Sort.Direction.DESC),
                                      @SortDefault(sort = "description", direction = Sort.Direction.ASC) }) Pageable pageable) {

        // Page<Quiz> quizzes = quizService.search(name, pageable);

//        Page<Quiz> quizzes = quizService.findAll(pageable); // TODO

//        model.addAttribute("quizzes", quizzes);
        return "parts/quizList";
    }

    @GetMapping(value = "/userList")
    @PreAuthorize("permitAll")
    public String getUserList(@RequestParam(value = "search", required = false) String search, Model model,
                              @PageableDefault(page = 0, size = 10) @SortDefault.SortDefaults({
                                      @SortDefault(sort = "username", direction = Sort.Direction.DESC),
                                      @SortDefault(sort = "email", direction = Sort.Direction.ASC) }) Pageable pageable) {
        model.addAttribute("users", userService.findAllBySearch(search, pageable));
        return "parts/userList";
    }

}
