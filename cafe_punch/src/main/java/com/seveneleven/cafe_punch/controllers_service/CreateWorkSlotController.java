package com.seveneleven.cafe_punch.controllers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.WorkSlotEntity;
import com.seveneleven.cafe_punch.models.WorkSlot;

@Service
public class CreateWorkSlotController {

    @Autowired
    WorkSlotEntity WorkSlot;

    public boolean createWorkSlot(WorkSlot workslot){
        return WorkSlot.createWorkSlot(workslot);
    }
}
