package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserProfileEntity;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class CreateUserProfileController {

    @Autowired
    UserProfileEntity UserProfile;

    public boolean createProfile(UserProfile userProfile){
        return UserProfile.createProfile(userProfile);
    }
    
}
