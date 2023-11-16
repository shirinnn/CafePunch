package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffBidsEntity;

@Service
public class AllocateWorkSlotController {

    @Autowired
    StaffBidsEntity staffBidsEntity;

    public boolean assignSlot(String empID, int wsID, String role){
        return staffBidsEntity.assignSlot(empID, wsID, role);
    }
}