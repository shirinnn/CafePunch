package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserAccountEntity;
import com.seveneleven.cafe_punch.models.UserAccount;

@Service
public class SearchUserAccountController {
    
    @Autowired UserAccountEntity UserAccount;

    public List<UserAccount> searchAccount(String fullname){
        return UserAccount.searchAccount(fullname);
    }
}
