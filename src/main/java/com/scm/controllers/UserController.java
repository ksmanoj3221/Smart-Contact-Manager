package com.scm.controllers;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.helpers.Helper;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    // user dashboard page
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String userDashboard() {
        return "user/dashboard";
    }

    // user profile page
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String userProfile(Authentication authentication) {
        logger.info("Calling getEmailOfLoggedInUser");
        String userName = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User Logged in name : {}", userName);
        return "user/profile";
    }

    // user add contact page

    // user view contacts

    // user edit contact

    // user delete contact

    // user search contact
}
