package com.seveneleven.cafe_punch.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seveneleven.cafe_punch.controllers_service.LoginController;
import com.seveneleven.cafe_punch.controllers_service.LogoutController;
import com.seveneleven.cafe_punch.models.UserAccount;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginPage {

    @Autowired LoginController loginController;
    @Autowired LogoutController logoutController;

    @GetMapping("/")
    public String LoginView(Model model) {
        model.addAttribute("userAccount", new UserAccount());
        return "Index.html";
    }
    
    @PostMapping("/processLogin")
    public String processLogin(UserAccount userAccount, Model model, HttpServletRequest request, @RequestParam("loginAs") String loginRole){

        // Console Log the role user choose to login as
        System.out.println("Logging in As: " + loginRole);

        // Initialise session
        HttpSession session = request.getSession();

        // Post data from userAccount attribute in html
        model.addAttribute("userAccount", userAccount);

        boolean validated = loginController.validateCredentials(userAccount.getEmpID(), userAccount.getPassword(), loginRole);
        if (validated){
            
            // Set session attributes
            session.setAttribute("currentUserID", userAccount.getEmpID());
            session.setAttribute("loginRole", loginRole);
            session.setAttribute("userName", loginController.getUserName(userAccount.getEmpID()).getLastName() + " " + loginController.getUserName(userAccount.getEmpID()).getFirstName());
            System.out.println("Setting currentUser as " + session.getAttribute("currentUserID"));

            if(loginRole.equals("Admin"))
                return "redirect:/userAccount/";
            else if(loginRole.equals("Owner"))
                return "redirect:/workslot/";
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        logoutController.logout();
        return "redirect:/";
    }
}
