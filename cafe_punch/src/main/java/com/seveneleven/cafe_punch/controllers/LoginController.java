package com.seveneleven.cafe_punch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/")
    public String displayLoginPage(Model model) {
        return "Index";
    }

    @GetMapping("/UserAccountManagement")
    public String showTest(Model model) {
        return "UserAccountManagement";
    }
    
}
