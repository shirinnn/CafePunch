package com.seveneleven.cafe_punch.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seveneleven.cafe_punch.controllers_service.CreateUserProfileController;
import com.seveneleven.cafe_punch.controllers_service.SearchUserProfileController;
import com.seveneleven.cafe_punch.controllers_service.SuspendUserProfileController;
import com.seveneleven.cafe_punch.controllers_service.UpdateUserProfileController;
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

    @Autowired
    SearchUserProfileController SearchController;

    @PostMapping("/search")
    public String UserProfileSearch(@RequestParam String name,Model model, HttpSession session){

        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // initialise list of user profiles return from controller
        List<UserProfile> userProfiles = SearchController.searchProfile(name);
        
        // pass list to html
        model.addAttribute("userProfiles", userProfiles);
        model.addAttribute("userName", "Admin");
        model.addAttribute("empID", currentUserID);

        return "UserProfileManagement.html";
    }

    @GetMapping("/createForm")
    public String CreateUserProfile(Model model, HttpSession session){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        // Redirect User who is not logging as admin back to login page
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // attribute to pass to html
        model.addAttribute("userName", "Admin"); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("profile", new UserProfile()); 
        
        return "UserProfileCreateForm.html";
    }

    @Autowired
    CreateUserProfileController CreateController;

    @PostMapping("/createForm/create")
    public String createProfile(UserProfile userProfile, Model model)
    {
        // post data from userAccount attributes in html
        model.addAttribute("profile", userProfile);
        System.out.println(userProfile.getProfileName());

        boolean result = CreateController.createProfile(userProfile);
        if (result){
            return "redirect:/userProfile/";
        } else {
            return "redirect:/userProfile/createForm";
        }
    }

    @Autowired 
    UpdateUserProfileController UpdateController;

    @GetMapping("/updateForm/{profileID}")
    public String DisplayUpdateProfileForm(Model model, HttpSession session, @PathVariable(name="profileID") int profileID)
    {
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String loginRole = (String) session.getAttribute("loginRole");
        
        // Redirect User who is not logging as admin back to login page
        if (currentUserID == null || !loginRole.equals("Admin")){
            return "redirect:/";
        }

        // Get Existing Information of the account by ID
        UserProfile profile = UpdateController.getProfileByID(profileID);

        // attribute to pass to html
        model.addAttribute("userName", "Admin"); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("profile", new UserProfile(profile.getProfileID(), profile.getProfileName(), profile.getPermissionType()));

        return "UserProfileUpdateForm.html";
    }

    @PostMapping("/updateForm/update/{profileID}")
    public String updateProfile(UserProfile profile, Model model, @PathVariable(name="profileID") String profileID){

        // post data from userAccount attributes in html
        model.addAttribute("profile", profile);

        boolean result = UpdateController.updateProfile(profile);

        if (result){
            return "redirect:/userProfile/";
        } else {
            return "redirect:/userProfile/updateForm/" + profileID;
        }
    }

    @Autowired 
    SuspendUserProfileController suspendController;
    @GetMapping("/suspend/{profileID}")
    public String SuspendProfile(Model model, @PathVariable(name="profileID") int profileID){

        boolean result = suspendController.suspendProfile(profileID);

        if (result){
            return "redirect:/userProfile/";
        } else {
            return "redirect:/";
        }
    }
    
}
