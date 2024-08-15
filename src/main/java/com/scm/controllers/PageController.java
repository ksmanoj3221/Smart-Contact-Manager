package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.forms.UserForm;


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
        UserForm userForm = new UserForm();
        // Default Value
        // userForm.setName("Manoj");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing regisger
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {
        //fecth form data

        //UserForm
        System.out.println(userForm);

        //Validate Form Data

        //Save to Database

        //message = Registration successful

        //redirect
        return "redirect:/register";
    }
    
}
