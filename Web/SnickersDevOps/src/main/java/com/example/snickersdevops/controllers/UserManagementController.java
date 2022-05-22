package com.example.snickersdevops.controllers;


import com.example.snickersdevops.models.User;
import com.example.snickersdevops.services.UserService;
import com.example.snickersdevops.services.usermanagement.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    public String login(@ModelAttribute User user) {
        return "login";
    }

    @RequestMapping(value = "/login-error", method = RequestMethod.GET)
    @PreAuthorize("permitAll")
    public String loginError(@ModelAttribute User user, Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated()")
    public String getAdminPage(Model model) {
        return "admin";
    }

//    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
//    @PreAuthorize("permitAll")
//    public String forgotPassword() {
//        return "forgotPassword";
//    }

//    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
//    @PreAuthorize("permitAll")
//    public ModelAndView forgotPassword(String email) {
//        User user = userService.findByEmail(email);
//        userManagementService.resendPassword(user);
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("header", messageSource.getMessage("label.forgotpassword.success.header", null, null));
//        mav.addObject("subheader", messageSource.getMessage("label.forgotpassword.success.subheader", null, null));
//        mav.setViewName("simplemessage");
//
//        return mav;
//    }

//    @RequestMapping(value = "/{user_id}/resetPassword", method = RequestMethod.GET)
//    @PreAuthorize("permitAll")
//    public ModelAndView resetPassword(@PathVariable Long user_id, String token) {
//        User user = userService.find(user_id);
//        userManagementService.verifyResetPasswordToken(user, token);
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("user", user);
//        mav.addObject("token", token);
//        mav.setViewName("resetPassword");
//
//        return mav;
//    }

//    @RequestMapping(value = "/{user_id}/resetPassword", method = RequestMethod.POST)
//    @PreAuthorize("permitAll")
//    public String resetPassword(@PathVariable Long user_id, String token, String password) {
//        User user = userService.find(user_id);
//        userManagementService.verifyResetPasswordToken(user, token);
//
//        userManagementService.updatePassword(user, password);
//
//        return "login";
//    }
}