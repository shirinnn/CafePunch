package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserProfileEntity;

@Service
public class SuspendUserProfileController {
    
    @Autowired UserProfileEntity UserProfile;

    public boolean suspendProfile(int profileID){
        return UserProfile.suspendAccount(profileID);
    }
}
