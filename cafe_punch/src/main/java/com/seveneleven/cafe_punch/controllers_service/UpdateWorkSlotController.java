package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.WorkSlotEntity;
import com.seveneleven.cafe_punch.models.WorkSlot;

@Service
public class UpdateWorkSlotController {
    
    @Autowired
    WorkSlotEntity WorkSlot;

    public boolean updateWorkSlot(WorkSlot workslot)
    {
        return WorkSlot.updateWorkSlot(workslot);
    }

    public WorkSlot getWSByID(int wsID){
        return WorkSlot.getWSByID(wsID);
    }
}
