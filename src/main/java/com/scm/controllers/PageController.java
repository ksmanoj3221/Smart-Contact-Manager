package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Manoj");
        model.addAttribute("currentPage", "/home");
        return "home";
    }

    //about
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("currentPage", "/about");
        model.addAttribute("isLoggedIn", true);
        return "about";
    }

    //services
    @RequestMapping("/services")
    public String servicePage(Model model){
        model.addAttribute("currentPage", "/services");
        return "services";
    }

    //contact
    @RequestMapping("/contact")
    public String contactPage(Model model){
        model.addAttribute("currentPage", "/contact");
        return "contact";
    }
    
    //Login
    @RequestMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("currentPage", "/login");
        return "login";
    }

    //register
    @RequestMapping("/register")
    public String signupPage(Model model){
        model.addAttribute("currentPage", "/register");
        return "register";
    }
}
