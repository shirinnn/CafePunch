package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffBidsEntity;

@Service
public class ReviewBidController {
    @Autowired 
    StaffBidsEntity StaffBids;

    public boolean approveBid(String empID, int bID, int wsID, String role){
        return StaffBids.approveBids(empID, bID, wsID, role);
    }

    public boolean rejectBid(int bID){
        return StaffBids.rejectBid(bID);
    }
}
