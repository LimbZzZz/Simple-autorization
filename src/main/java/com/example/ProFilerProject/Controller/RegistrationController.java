package com.example.ProFilerProject.Controller;

import com.example.ProFilerProject.Entity.User;
import com.example.ProFilerProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationUser(){
        return "registration";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user){
        userService.createUser(user);
        System.out.println(userService.getAllUsers());
        return "redirect:/home";
    }
}
