package com.seveneleven.cafe_punch.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seveneleven.cafe_punch.controllers_service.ViewUserAccountController;
import com.seveneleven.cafe_punch.models.UserAccount;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/userAccount")
public class UserAccountPage {

    @Autowired
    ViewUserAccountController controller;

    // Using /userAccount/ to view all userAccounts
    @GetMapping("/")
    public String userAccountView(Model model, HttpSession session) {
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // Get list of user Accounts
        List<UserAccount> userAccounts = controller.viewUserAccounts();

        // attributes to pass to html
        model.addAttribute("userAccounts", userAccounts); // pasing the list of userAccounts
        model.addAttribute("userName", "Admin");
        model.addAttribute("empID", currentUserID);

        return "UserAccountManagement";
    }

    @GetMapping("/create")
    public String CreateUserAccount(Model model, HttpSession session)
    {
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        // Redirect User who is not logging as admin back to login page
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // get the data from html, pass to controller

        // attribute to pass to html
        model.addAttribute("userName", "Admin");
        model.addAttribute("empID", currentUserID);

        return "UserAccountCreateForm.html";
    }

    @GetMapping("/update") // add on /{empID}
    public String UpdateUserAccount(Model model)
    {
        return "UserAccountUpdateForm.html";
    }

    @GetMapping("/suspend") // add on /{empID}
    public String SuspendUserAccount(Model model){
        return "";
    }
}
