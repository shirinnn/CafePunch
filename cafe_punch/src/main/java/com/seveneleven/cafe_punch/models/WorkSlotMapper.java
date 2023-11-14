package com.seveneleven.cafe_punch.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WorkSlotMapper implements RowMapper<WorkSlot>{

    @Override
    public WorkSlot mapRow(ResultSet rs, int rowNum) throws SQLException {
        WorkSlot workSlot = new WorkSlot(rs.getInt("wsID"), rs.getString("date"), rs.getString("startTime"), rs.getString("endTime"),  
                                        rs.getInt("noOfCashier"), rs.getInt("noOfChef"), rs.getInt("noOfWaiter"));

        return workSlot;
    }
    
}
