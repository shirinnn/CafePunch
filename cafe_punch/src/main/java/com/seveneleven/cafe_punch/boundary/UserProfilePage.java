package com.seveneleven.cafe_punch.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seveneleven.cafe_punch.controllers_service.ViewUserProfileController;
import com.seveneleven.cafe_punch.models.UserProfile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/userProfile")
public class UserProfilePage {

    @Autowired
    ViewUserProfileController controller;

    // using /userProfile/ to view all user profiles
    @GetMapping("/")
    public String UserProfileView(Model model, HttpSession session){

        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // initialise list of user profiles return from controller
        List<UserProfile> userProfiles = controller.viewUserProfile();
        
        // pass list to html
        model.addAttribute("userProfiles", userProfiles);
        model.addAttribute("userName", "Admin");
        model.addAttribute("empID", currentUserID);

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
