package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserAccountEntity;

@Service
public class LoginController {
    @Autowired UserAccountEntity UserAccount;

    public boolean validateCredentials(String empID, String password, String loginRole){
        return UserAccount.validateCredentials(empID, password, loginRole);
    }
}
