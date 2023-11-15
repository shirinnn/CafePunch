package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffBidsEntity;
import com.seveneleven.cafe_punch.models.StaffBid;

@Service
public class ViewBidController {

    @Autowired
    StaffBidsEntity staffBidsEntity;

    public List<StaffBid> viewBidsByID(String empID){
        return staffBidsEntity.viewBidsByID(empID);
    }
}
