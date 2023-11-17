package com.seveneleven.cafe_punch.boundary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seveneleven.cafe_punch.controllers_service.CreateUserAccountController;
import com.seveneleven.cafe_punch.controllers_service.SearchUserAccountController;
import com.seveneleven.cafe_punch.controllers_service.SuspendUserAccountController;
import com.seveneleven.cafe_punch.controllers_service.UpdateUserAccountController;
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
    public String DisplayUserAccounts(Model model, HttpSession session) {
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");

        // Redirect non-admin user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // Get list of user Accounts
        List<UserAccount> userAccounts = ViewController.viewAccounts();

        // To populate dropdown list based on UserProfiles Table
        List<UserProfile> userProfiles = ViewController.getProfiles();

        // attributes to pass to html
        model.addAttribute("userAccounts", userAccounts); // pasing the list of userAccounts
        model.addAttribute("userName", "Admin"); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar user id
        model.addAttribute("userProfiles", userProfiles);

        return "UserAccountManagement";
    }

    @Autowired
    SearchUserAccountController SearchController;

    @PostMapping("/search")
    public String SearchUserAccounts(@RequestParam String fullname,Model model, HttpSession session){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");

        // Redirect non-admin user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // Get list of user Accounts
        List<UserAccount> userAccounts = SearchController.searchAccount(fullname);

        // To populate dropdown list based on UserProfiles Table
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
    public String DisplayCreateAccountForm(Model model, HttpSession session)
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
    public String createAccount(UserAccount userAccount, Model model)
    {
        // post data from userAccount attributes in html
        model.addAttribute("userAccount", userAccount);

        boolean result = CreateController.createAccount(userAccount);
        if (result){
            return "redirect:/userAccount/";
        } else {
            return "redirect:/userAccount/createForm";
        }
    }

    @Autowired 
    UpdateUserAccountController UpdateController;

    @GetMapping("/updateForm/{empID}")
    public String DisplayUpdateAccountForm(Model model, HttpSession session, @PathVariable(name="empID") String empID)
    {
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        // Redirect User who is not logging as admin back to login page
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // get profiles from db to populate the dropdown list in html
        List<UserProfile> profiles = UpdateController.getProfiles();

        // Get Existing Information of the account by ID
        UserAccount account = UpdateController.getUserAccountByID(empID);

        // attribute to pass to html
        model.addAttribute("userName", "Admin"); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("profiles", profiles); // pass list to html to populate dropdown list
        model.addAttribute("account", new UserAccount(account.getEmpID(), account.getFirstName(), account.getLastName(), account.getEmail(),
                                                                    account.getGender(), account.getPassword(), account.getProfileID(), account.getStatus()));

        return "UserAccountUpdateForm.html";
    }

    @PostMapping("/updateForm/update/{empID}")
    public String updateAccount(UserAccount account, Model model, @PathVariable(name="empID") String empID, RedirectAttributes redirAttr){

        // post data from userAccount attributes in html
        model.addAttribute("account", account);

        boolean result = UpdateController.updateAccount(account);

        if (result){
            redirAttr.addFlashAttribute("message", "Updated Successfully");
            return "redirect:/userAccount/";
        } else {
            return "redirect:/userAccount/updateForm/" + empID;
        }
    }

    @Autowired 
    SuspendUserAccountController suspendController;

    @GetMapping("/suspend/{empID}") // add on /{empID}
    public String SuspendUserAccount(Model model, @PathVariable(name="empID") String empID, RedirectAttributes redirAttr){

        boolean result = suspendController.suspendAccount(empID);

        if (result){
            redirAttr.addFlashAttribute("message", "Suspended Successfully");
            return "redirect:/userAccount/";
        } else {
            return "redirect:/";
        }
    }


}
