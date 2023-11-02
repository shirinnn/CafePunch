package com.seveneleven.cafe_punch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.data.UserProfileEntity;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class UserProfileController {

    @Autowired
    UserProfileEntity UserProfile;
    
    public List<UserProfile> viewUserProfile()
    {
        return UserProfile.viewUserProfile();
    }
}
