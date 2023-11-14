package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.WorkSlotEntity;

@Service
public class DeleteWorkSlotController {
    
    @Autowired 
    WorkSlotEntity WorkSlot;

    public boolean deleteWorkslot(int wsID){
        return WorkSlot.deleteWorkslot(wsID);
    }

}
