package com.example.ProFilerProject.Controller;

import com.example.ProFilerProject.Entity.User;
import com.example.ProFilerProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AutorizationController {
    private UserService userService;
    private User currentUser;

    @Autowired
    public AutorizationController(UserService userService){
        currentUser = new User();
        this.userService = userService;
    }

    @RequestMapping("/home")
    public String homepage(){
        return "autorization";
    }

    @PostMapping("/checkUser")
    public String autorization(@ModelAttribute("username") String username, @ModelAttribute("password") String password){
        List<User> userList = userService.getAllUsers();
        for(User user : userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                currentUser = user;
                return "redirect:/profile";
            }
        }
        return "redirect:/registration";
    }

    @GetMapping("/profile")
    public String profilePage(Model model){
        if(currentUser != null && currentUser.getId() != null){
            model.addAttribute("username", currentUser.getUsername());
            model.addAttribute("email", currentUser.getEmail());
            currentUser = null;
            return "profile";
        }
        return "redirect:/home";
    }
}
