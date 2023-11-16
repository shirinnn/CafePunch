package com.seveneleven.cafe_punch.boundary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seveneleven.cafe_punch.controllers_service.AllocateWorkSlotController;
import com.seveneleven.cafe_punch.controllers_service.ViewBidController;
import com.seveneleven.cafe_punch.controllers_service.ViewStaffListController;
import com.seveneleven.cafe_punch.controllers_service.ViewWorkSlotController;
import com.seveneleven.cafe_punch.models.Staff;
import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserProfile;
import com.seveneleven.cafe_punch.models.WorkSlot;

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

    @GetMapping("/")
    public String viewAllCafeStaff(Model model, HttpSession session){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");

        // Redirect non-manager user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Manager")){
            return "redirect:/";
        }

        List<Staff> staffs = ViewController.viewStaffs();

        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar user id
        model.addAttribute("staffs", staffs);

        return "StaffManagement";
    }

    @Autowired
    ViewWorkSlotController viewWorkSlotController;

    @GetMapping("/wsList/{empID}/{role}")
    public String workSlotList(Model model, HttpSession session, @PathVariable(name="role") String role, @PathVariable(name="empID") String empID){

        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");

        // Redirect non-manager user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Manager")){
            return "redirect:/";
        }

        List<WorkSlot> workslots = viewWorkSlotController.getWSByRole(role);
        

        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar user id
        model.addAttribute("workslots", workslots);
        model.addAttribute("eID", empID);
        model.addAttribute("role", role);

        return "WorkSlotAllocate";
    }

    @Autowired
    AllocateWorkSlotController allocateWorkSlotController;

    @GetMapping("/wsList/allocate/{empID}/{wsID}/{role}")
    public String allocateWorkSlot(@PathVariable(name="empID") String empID, @PathVariable(name="wsID") int wsID, @PathVariable(name="role") String role){

        System.out.println(empID);
        boolean result = allocateWorkSlotController.assignSlot(empID, wsID, role);

        if (result)
            return "redirect:/staff/";
        else 
            return "redirect:/"  ;  
    }
}
