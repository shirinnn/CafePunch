package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserProfileEntity;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class UpdateUserProfileController {
    
    @Autowired
    UserProfileEntity UserProfile;

    public boolean updateProfile(UserProfile userProfile){
        return UserProfile.updateProfile(userProfile);
    }

    public UserProfile getProfileByID(int profileID){
        return UserProfile.getProfileByID(profileID);
    }
}
