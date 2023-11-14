package com.seveneleven.cafe_punch.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seveneleven.cafe_punch.controllers_service.ViewStaffListController;
import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserProfile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/staff")
public class StaffListPage {

    @Autowired
    ViewStaffListController ViewController;
    
    // Owner Staff List
    @GetMapping("/viewList")
    public String viewStaffList(HttpSession session, Model model){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");

        // Redirect non-owner user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Owner")){
            return "redirect:/";
        }

        // Get list of user Accounts
        List<UserAccount> userAccounts = ViewController.viewStaffList();

        // To populate dropdown list based on UserProfiles Table
        List<UserProfile> userProfiles = ViewController.getProfiles();

        // attributes to pass to html
        model.addAttribute("userAccounts", userAccounts); // pasing the list of userAccounts
        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar user id
        model.addAttribute("userProfiles", userProfiles);

        return "StaffList";
    }
}
