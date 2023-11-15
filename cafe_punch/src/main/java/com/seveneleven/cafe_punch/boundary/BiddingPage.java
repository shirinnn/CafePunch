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
import com.seveneleven.cafe_punch.controllers_service.SearchBidController;
import com.seveneleven.cafe_punch.controllers_service.ViewBidController;
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


}
