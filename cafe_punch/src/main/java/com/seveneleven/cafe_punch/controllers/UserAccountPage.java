package com.seveneleven.cafe_punch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.service.UserAccountController;

@Controller
@RequestMapping("/userAccount")
public class UserAccountPage {

    @Autowired
    UserAccountController controller;

    // Using /user/ to view all userAccounts
    @GetMapping("/")
    public String userAccountView(Model model) {
        List<UserAccount> userAccounts = controller.viewUserAccounts();

        // attributes to pass to html
        model.addAttribute("userAccounts", userAccounts);

        return "UserAccountManagement.html";
    }
}
