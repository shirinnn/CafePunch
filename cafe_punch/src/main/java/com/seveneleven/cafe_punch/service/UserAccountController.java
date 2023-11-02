package com.seveneleven.cafe_punch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.data.UserAccountEntity;
import com.seveneleven.cafe_punch.models.UserAccount;

@Service
public class UserAccountController {
    
    @Autowired
    UserAccountEntity UserAccount;

    public List<UserAccount> viewUserAccounts(){
        return UserAccount.viewUserAccounts();
    }
}
