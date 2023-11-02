package com.seveneleven.cafe_punch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPage {

    @GetMapping("/")
    public String LoginView(Model model) {
        return "Index";
    }
    
}
