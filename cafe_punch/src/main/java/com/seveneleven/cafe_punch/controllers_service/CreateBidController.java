package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffBidsEntity;

@Service
public class CreateBidController {
    @Autowired
    StaffBidsEntity StaffBids;

    public boolean createBid(String empID, int wsID, String role){
        return StaffBids.createBid(empID, wsID, role);
    }
}
