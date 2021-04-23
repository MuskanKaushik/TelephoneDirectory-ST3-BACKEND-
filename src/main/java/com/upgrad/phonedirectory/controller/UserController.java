package com.upgrad.phonedirectory.controller;

import com.upgrad.phonedirectory.model.User;
import com.upgrad.phonedirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // GET Request to "/login
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // POST Request to "/login"
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String loginUser(User user, HttpSession session) {
        User existingUser = userService.login(user);

        // check if the credentials match
        if(existingUser != null) {
            // Creating User Session
            session.setAttribute("LoggedUser", existingUser);
            System.out.println("USER FOUND!!");
            return "redirect:/posts";
        } else {
            System.out.println("USER DOES NOT EXIST!!");
            return "login";
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/signup")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String userRegistration(User user) {
        // Business logic to save the credentials. of the users to teh given database
        boolean status = userService.registerUser(user);
        return "redirect:login";
    }

    @RequestMapping("/users/logout")
    public String userLogout() {
        return "redirect:/";
    }
}
