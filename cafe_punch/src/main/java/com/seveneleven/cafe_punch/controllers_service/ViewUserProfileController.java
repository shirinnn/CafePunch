package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserProfileEntity;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class ViewUserProfileController {

    @Autowired
    UserProfileEntity UserProfile;
    
    public List<UserProfile> viewUserProfile()
    {
        return UserProfile.viewUserProfile();
    }
}
