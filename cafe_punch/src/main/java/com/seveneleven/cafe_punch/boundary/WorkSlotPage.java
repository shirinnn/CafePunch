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

import com.seveneleven.cafe_punch.controllers_service.CreateWorkSlotController;
import com.seveneleven.cafe_punch.controllers_service.DeleteWorkSlotController;
import com.seveneleven.cafe_punch.controllers_service.SearchWorkSlotController;
import com.seveneleven.cafe_punch.controllers_service.UpdateWorkSlotController;
import com.seveneleven.cafe_punch.controllers_service.ViewWorkSlotController;
import com.seveneleven.cafe_punch.models.WorkSlot;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/workslot")
public class WorkSlotPage {

    @Autowired
    ViewWorkSlotController viewWorkSlotController;
    
    @GetMapping("/")
    public String viewWorkSlot(HttpSession session, Model model){
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");

        // Redirect non-owner user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Owner")){
            return "redirect:/";
        }

        List<WorkSlot> workslots = viewWorkSlotController.viewWorkSlot();

        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar user id
        model.addAttribute("workslots", workslots);

        return "WorkSlotManagement";
    }

    @GetMapping("/createForm")
    public String CreateWorkSlot(Model model, HttpSession session){
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");
        
        // Redirect non-owner user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Owner")){
            return "redirect:/";
        }

        // attribute to pass to html
        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("workslot", new WorkSlot());
        
        return "WorkSlotCreateForm";
    }

    @Autowired
    CreateWorkSlotController createWorkSlotController;

    @PostMapping("/createForm/create")
    public String createWorkSlot(WorkSlot workSlot, Model model)
    {
        model.addAttribute("workslot", workSlot);

        boolean result = createWorkSlotController.createWorkSlot(workSlot);
        if (result){
            return "redirect:/workslot/";
        } else {
            return "redirect:/workslot/createForm";
        }
    }

    @Autowired
    UpdateWorkSlotController updateWorkSlotController;

    @GetMapping("/updateForm/{wsID}")
    public String UpdateWorkSlotForm(Model model, HttpSession session, @PathVariable(name="wsID") int wsID)
    {
        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");
        
        // Redirect non-owner user away and users who access via url
        if (currentUserID == null || !loginRole.equals("Owner")){
            return "redirect:/";
        }

        // Get Existing Info of the workslot
        WorkSlot workslot = updateWorkSlotController.getWSByID(wsID);

        // attribute to pass to html
        model.addAttribute("userName", userName); // For the nav bar user name
        model.addAttribute("empID", currentUserID); // For the nav bar emp ID
        model.addAttribute("workslot", new WorkSlot(workslot.getWsID(), workslot.getDate(), workslot.getStartTime(), workslot.getEndTime(), workslot.getNoOfCashier(),  workslot.getNoOfChef(), workslot.getNoOfWaiter()));

        return "WorkSlotUpdateForm.html";
    }

    @PostMapping("/updateForm/update/{wsID}")
    public String updateProfile(WorkSlot workslot, Model model, @PathVariable(name="wsID") String wsID){

        // post data from userAccount attributes in html
        model.addAttribute("workslot", workslot);

        //boolean result = UpdateController.updateProfile(profile);
        boolean result = updateWorkSlotController.updateWorkSlot(workslot);

        if (result){
            return "redirect:/workslot/";
        } else {
            return "redirect:/workslot/updateForm/" + wsID;
        }
    }

    @Autowired
    DeleteWorkSlotController deleteWorkSlotController;

    @GetMapping("/delete/{wsID}")
    public String SuspendProfile(Model model, @PathVariable(name="wsID") int wsID){

        boolean result = deleteWorkSlotController.deleteWorkslot(wsID);

        if (result){
            return "redirect:/workslot/";
        } else {
            return "redirect:/";
        }
    }

    @Autowired
    SearchWorkSlotController searchWorkSlotController;

    @PostMapping("/search")
    public String UserProfileSearch(@RequestParam String date,Model model, HttpSession session){

        // getting session attributes
        String currentUserID = (String) session.getAttribute("currentUserID");
        String userName = (String) session.getAttribute("userName");
        String loginRole = (String) session.getAttribute("loginRole");
        
        if (currentUserID == null || !loginRole.equals("Owner")){
            return "redirect:/";
        }

        // initialise list of user profiles return from controller
        List<WorkSlot> workslots = searchWorkSlotController.searchWorkSlot(date);
        
        // pass list to html
        model.addAttribute("workslots", workslots);
        model.addAttribute("userName", userName);
        model.addAttribute("empID", currentUserID);

        return "WorkSlotManagement.html";
    }
}

