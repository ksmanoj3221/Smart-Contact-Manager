package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Manoj");
        return "home";
    }

    //about
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isLoggedIn", true);
        return "about";
    }

    //about
    @RequestMapping("/services")
    public String servicePage(Model model){
        return "services";
    }
    
}
