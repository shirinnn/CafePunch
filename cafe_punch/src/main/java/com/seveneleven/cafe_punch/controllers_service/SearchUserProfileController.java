package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.UserProfileEntity;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class SearchUserProfileController {

    @Autowired UserProfileEntity UserProfile;

    public List<UserProfile> searchProfile(String name){
        return UserProfile.searchProfile(name);
    }
    
    
}
