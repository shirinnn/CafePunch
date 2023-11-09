package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserAccountEntity;

@Service
public class SuspendUserAccountController {
    @Autowired 
    UserAccountEntity UserAccount;

    public boolean suspendUserAccount(String empID){
        return UserAccount.suspendUserAccount(empID);
    }
}
