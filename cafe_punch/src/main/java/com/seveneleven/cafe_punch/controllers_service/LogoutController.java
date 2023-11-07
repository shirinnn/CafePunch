package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;

@Service
public class LogoutController {

    @Autowired
    HttpSession session;

    public void logout(){
        session.invalidate();
    }
    
}
