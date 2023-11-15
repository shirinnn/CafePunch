package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.StaffBidsEntity;
import com.seveneleven.cafe_punch.models.StaffBid;

@Service
public class SearchBidController {
    @Autowired
    StaffBidsEntity staffBids;

    public List<StaffBid> searchBidsByStatus(String empID, String status){
        return staffBids.searchBidsByStatus(empID, status);
    }
}
