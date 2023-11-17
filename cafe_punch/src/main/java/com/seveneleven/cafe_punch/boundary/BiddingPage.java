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

import com.seveneleven.cafe_punch.controllers_service.DeleteBidController;
import com.seveneleven.cafe_punch.controllers_service.ReviewBidController;
import com.seveneleven.cafe_punch.controllers_service.SearchBidController;
import com.seveneleven.cafe_punch.controllers_service.UpdateWorkSlotController;
import com.seveneleven.cafe_punch.controllers_service.ViewBidController;
import com.seveneleven.cafe_punch.controllers_service.ViewStaffListController;
import com.seveneleven.cafe_punch.models.Staff;
import com.seveneleven.cafe_punch.models.StaffBid;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/bid")
public class BiddingPage {
 
    @Autowired
    ViewBidController viewBidController;

    @GetMapping("/status")
    public String viewBidResult(Model model, HttpSession session){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Staff")){
            return "redirect:/";
        }

        List<StaffBid> bids = viewBidController.viewBidsByID(currentUserID);


        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("bids", bids);

        return "StaffBidsStatus";
    }

    @Autowired
    SearchBidController searchBidController;

    @PostMapping("/status/search")
    public String searchBidResult(@RequestParam String status,Model model, HttpSession session){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Staff")){
            return "redirect:/";
        }

        List<StaffBid> bids = searchBidController.searchBidsByStatus(currentUserID, status);

        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("bids", bids);

        return "StaffBidsStatus";
    }

    @Autowired
    DeleteBidController deleteBidController;

    @GetMapping("/status/delete/{bID}")
    public String deleteBid(Model model, @PathVariable(name="bID") int bID){

        boolean result = deleteBidController.deleteBid(bID);

        if (result)
            return "redirect:/bid/status";
        else
            return "redirect:/";
    }

    @GetMapping("/review")
    public String reviewBid(Model model, HttpSession session){

        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Manager")){
            return "redirect:/";
        }

        List<StaffBid> bids = viewBidController.viewAllBids();

        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("bids", bids);

        return "ReviewBidManagement";
    }

    @Autowired
    ReviewBidController reviewBidController;

    @GetMapping("/review/approve/{empID}/{bID}/{wsID}/{role}")
    public String approveBid(Model model, HttpSession session, @PathVariable(name="empID") String empID, @PathVariable(name="bID") int bID, @PathVariable(name="wsID") int wsID, @PathVariable(name="role") String role){

        boolean result = reviewBidController.approveBid(empID, bID, wsID, role);

        if (result){
            return "redirect:/bid/review";
        }
        // set a flash message
        return "redirect:/bid/review";
    }

    @GetMapping("/review/reject/{bID}")
    public String rejectBid(Model model, HttpSession session, @PathVariable(name="bID") int bID){

        boolean result = reviewBidController.rejectBid(bID);

        if (result){
            return "redirect:/bid/review";
        }
        // set a flash message
        return "redirect:/bid/review";
    }

    @PostMapping("/review/search")
    public String searchBidReview(@RequestParam String status,Model model, HttpSession session){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Manager")){
            return "redirect:/";
        }

        List<StaffBid> bids = searchBidController.searchBidsReviewByStatus(status);

        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("bids", bids);

        return "ReviewBidManagement";
    }

    @Autowired
    ViewStaffListController viewStaffListController;

    @GetMapping("/review/updateForm/{bID}/{role}")
    public String updateSlot(Model model, HttpSession session, @PathVariable(name="bID") int bID, @PathVariable(name="role") String role){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");

        // Redirect non-manager user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Manager")){
            return "redirect:/";
        }

        List<Staff> staffs = viewStaffListController.viewStaffsByRole(role);

        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar user id
        model.addAttribute("staffs", staffs);
        model.addAttribute("bID", bID);
        model.addAttribute("role", role);

        return "ReviewBidUpdateForm";
    }

    @Autowired
    UpdateWorkSlotController updateWorkSlotController;

    @PostMapping("/review/update/{bID}")
    public String updateSlot(@RequestParam String empID, @PathVariable(name="bID") int bID){
        
        boolean result = updateWorkSlotController.updateSlot(bID, empID);

        if (result){
            return "redirect:/staff/";
        } 
        return "redirect:/";
    }

}
