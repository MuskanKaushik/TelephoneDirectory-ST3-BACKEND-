package com.upgrad.phonedirectory.controller;


import com.upgrad.phonedirectory.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }

}