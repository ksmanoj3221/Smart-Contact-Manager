package com.scm.controllers;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {
    @Autowired
    private UserService userService;


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
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,  HttpSession session) {
        //fecth form data

        //UserForm
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        //Save to Database

        //cant store SELF
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("/images/profile.png")
        // .build();
        // userService.saveUser(user);

        // System.out.println("User saved");

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "/images/profile.png");

        User savedUser = userService.saveUser(user);

        System.out.println("user saved :");

        //message = Registration successful
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);

        //redirect
        return "redirect:/register";
    }
    
}
