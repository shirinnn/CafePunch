package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffDetailsEntity;
import com.seveneleven.cafe_punch.entity.UserProfileEntity;
import com.seveneleven.cafe_punch.models.Staff;
import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserProfile;

@Service
public class ViewStaffListController {

    @Autowired
    StaffDetailsEntity StaffDetails;
    
    public List<UserAccount> viewStaffList(){
        return StaffDetails.viewStaffList();
    }

    public List<Staff> viewStaffs(){
        return StaffDetails.viewStaffs();
    }

    public Staff getStaffByID(String empID){
        return StaffDetails.getStaffByID(empID);
    }

    public List<Staff> viewStaffsByRole(String role){
        return StaffDetails.viewStaffsByRole(role);
    }

    @Autowired
    UserProfileEntity userProfile;
    public List<UserProfile> getProfiles()
    {
        List<UserProfile> userProfiles = userProfile.viewUserProfile(); 
        return userProfiles;
    }
}
