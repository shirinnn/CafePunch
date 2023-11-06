package com.seveneleven.cafe_punch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seveneleven.cafe_punch.models.UserProfile;
import com.seveneleven.cafe_punch.service.UserProfileController;

@Controller
@RequestMapping("/userProfile")
public class UserProfilePage {

    @Autowired
    UserProfileController controller;

    // using /userProfile/ to view all user profiles
    @GetMapping("/")
    public String UserProfileView(Model model){

        // initialise list of user profiles return from controller
        List<UserProfile> userProfiles = controller.viewUserProfile();
        
        // pass list to html
        model.addAttribute("userProfiles", userProfiles);

        return "UserProfileManagement.html";
    }

    @GetMapping("/create")
    public String CreateUserProfile(Model model){

        
        return "UserProfileForm.html";
    }

    @GetMapping("/update")
    public String UpdateUserProfile(Model model){

        
        return "UserProfileForm.html";
    }
    
}
