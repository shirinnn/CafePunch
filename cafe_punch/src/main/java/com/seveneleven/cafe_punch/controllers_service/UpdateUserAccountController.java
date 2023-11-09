package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserAccountEntity;
import com.seveneleven.cafe_punch.entity.UserProfileEntity;
import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class UpdateUserAccountController {
    @Autowired 
    UserAccountEntity UserAccount;
    
    public boolean updateAccount(UserAccount userAccount){
        return UserAccount.updateAccount(userAccount);
    }

    public UserAccount getUserAccountByID(String empID)
    {
        return UserAccount.getUserAccountByID(empID);
    }

    @Autowired
    UserProfileEntity userProfile;
    public List<UserProfile> getProfiles()
    {
        List<UserProfile> userProfiles = userProfile.viewUserProfile(); 
        return userProfiles;
    }
    
}
