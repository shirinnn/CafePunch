package com.seveneleven.cafe_punch.boundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seveneleven.cafe_punch.controllers_service.CreateUserAccountController;
import com.seveneleven.cafe_punch.controllers_service.ViewUserAccountController;
import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserProfile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/userAccount")
public class UserAccountPage {

    @Autowired
    ViewUserAccountController ViewController;

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
        List<UserAccount> userAccounts = ViewController.viewUserAccounts();
        List<UserProfile> userProfiles = ViewController.getProfiles();

        // attributes to pass to html
        model.addAttribute("userAccounts", userAccounts); // pasing the list of userAccounts
        model.addAttribute("userName", "Admin"); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar user id
        model.addAttribute("userProfiles", userProfiles);

        return "UserAccountManagement";
    }

    @Autowired 
    CreateUserAccountController CreateController;

    @GetMapping("/createForm")
    public String CreateUserAccount(Model model, HttpSession session)
    {
        List<UserProfile> profiles = new ArrayList<UserProfile>();
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        // Redirect User who is not logging as admin back to login page
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // get profiles from db to populate the dropdown list in html
        profiles = CreateController.getProfiles();

        // attribute to pass to html
        model.addAttribute("userName", "Admin"); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("profiles", profiles); // pass list to html to populate dropdown list
        model.addAttribute("userAccount", new UserAccount()); 

        return "UserAccountCreateForm.html";
    }

    @PostMapping("/createForm/create")
    public String createUserAccount(UserAccount userAccount, Model model)
    {
        model.addAttribute("userAccount", userAccount);

        boolean result = CreateController.createAccount(userAccount);
        if (result){
            return "redirect:/userAccount/";
        } else {
            return "redirect:/userAccount/createForm";
        }
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
