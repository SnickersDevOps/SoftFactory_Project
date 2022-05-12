package com.example.snickersdevops.controllers;

import com.example.snickersdevops.controllers.utils.RestVerifier;
import com.example.snickersdevops.exсeptions.ModelVerificationException;
import com.example.snickersdevops.models.AuthenticatedUser;
import com.example.snickersdevops.models.Question;
import com.example.snickersdevops.models.Quiz;
import com.example.snickersdevops.repository.UserRepository;
import com.example.snickersdevops.services.QuestionServiceImpl;
import com.example.snickersdevops.services.QuizServiceImpl;
import com.example.snickersdevops.services.UserService;
import com.example.snickersdevops.services.accesscontrol.AccessControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    QuestionServiceImpl questionService;

    @Autowired
    QuizServiceImpl quizService;

    @Autowired
    AccessControlService<Quiz> accessControlServiceQuiz;

    @Autowired
    AccessControlService<Question> accessControlServiceQuestion;

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

    @GetMapping("/test")
    public String testPage(){
        return "test";
    }

    @GetMapping("/500")
    public String serverErrorPage(){
        return "errors/500";
    }

    @GetMapping("/404")
    public String notFoundPage(){
        return "errors/404";
    }

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

    @GetMapping(value = "/createQuiz")
    @PreAuthorize("isAuthenticated()")
    public String newQuiz(Map<String, Object> model) {
        return "createQuiz";
    }

    @RequestMapping(value = "/createQuiz", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated()")
    public String newQuiz(@AuthenticationPrincipal AuthenticatedUser user, @Valid Quiz quiz, BindingResult result,
                          Map<String, Object> model) {
        Quiz newQuiz;

        try {
            RestVerifier.verifyModelResult(result);
            newQuiz = quizService.save(quiz, user.getUser());
        } catch (ModelVerificationException e) {
            return "createQuiz";
        }

        return "redirect:/editQuiz/" + newQuiz.getId();
    }

    @RequestMapping(value = "/editQuiz/{quiz_id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editQuiz(@PathVariable long quiz_id) {
        Quiz quiz = quizService.find(quiz_id);
        accessControlServiceQuiz.canCurrentUserUpdateObject(quiz);

        ModelAndView mav = new ModelAndView();
        mav.addObject("quiz", quiz);
        mav.setViewName("editQuiz");

        return mav;
    }

    @RequestMapping(value = "/editAnswer/{question_id}", method = RequestMethod.GET)
    @PreAuthorize("isAuthenticated()")
    public ModelAndView editAnswer(@PathVariable long question_id) {
        Question question = questionService.find(question_id);
        accessControlServiceQuestion.canCurrentUserUpdateObject(question);

        ModelAndView mav = new ModelAndView();
        mav.addObject("question", question);
        mav.setViewName("editAnswers");

        return mav;
    }

    @RequestMapping(value = "/quiz/{quiz_id}", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    public ModelAndView getQuiz(@PathVariable long quiz_id) {
        Quiz quiz = quizService.find(quiz_id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("quiz", quiz);
        mav.setViewName("quizView");

        return mav;
    }

    @RequestMapping(value = "/quiz/{quiz_id}/play", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    public ModelAndView playQuiz(@PathVariable long quiz_id) {
        Quiz quiz = quizService.find(quiz_id);

        ModelAndView mav = new ModelAndView();
        mav.addObject("quiz", quiz);
        mav.setViewName("playQuiz");

        return mav;
    }

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
