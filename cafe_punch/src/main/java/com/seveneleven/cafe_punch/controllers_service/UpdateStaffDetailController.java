package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffDetailsEntity;
import com.seveneleven.cafe_punch.models.Staff;

@Service
public class UpdateStaffDetailController {
    @Autowired
    StaffDetailsEntity Staff;

    public boolean updateStaffDetail(Staff staff){
        return Staff.updateStaffDetail(staff);
    }

}
