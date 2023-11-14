package com.seveneleven.cafe_punch.controllers_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seveneleven.cafe_punch.entity.WorkSlotEntity;
import com.seveneleven.cafe_punch.models.WorkSlot;

@Service
public class SearchWorkSlotController {
    
    @Autowired
    WorkSlotEntity WorkSlot;

    public List<WorkSlot> searchWorkSlot(String date){
        return WorkSlot.searchWorkSlot(date);
    }
}
