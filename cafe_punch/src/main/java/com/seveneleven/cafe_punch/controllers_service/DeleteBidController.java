package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffBidsEntity;

@Service
public class DeleteBidController {
    @Autowired
    StaffBidsEntity StaffBids;

    public boolean deleteBid(int bID){
        return StaffBids.deleteBid(bID);
    }
}
