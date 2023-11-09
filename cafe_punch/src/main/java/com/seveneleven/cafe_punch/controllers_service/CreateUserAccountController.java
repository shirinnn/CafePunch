package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserAccountEntity;
import com.seveneleven.cafe_punch.entity.UserProfileEntity;
import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class CreateUserAccountController {
    @Autowired 
    UserAccountEntity UserAccount;

    public boolean createAccount(UserAccount userAccount){
        return UserAccount.createAccount(userAccount);
    }

    @Autowired
    UserProfileEntity userProfile;
    public List<UserProfile> getProfiles()
    {
        List<UserProfile> userProfiles = userProfile.viewUserProfile(); 
        return userProfiles;
    }
}
