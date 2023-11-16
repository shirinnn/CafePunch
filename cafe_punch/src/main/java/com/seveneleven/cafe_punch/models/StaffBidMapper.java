package com.seveneleven.cafe_punch.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StaffBidMapper implements RowMapper<StaffBid>{

    @Override
    public StaffBid mapRow(ResultSet rs, int rowNum) throws SQLException {
        StaffBid staffBid = new StaffBid(rs.getInt("bID"), rs.getString("empID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("role"), rs.getInt("availableWorkSlot"), rs.getInt("wsID"), 
                                rs.getString("date"), rs.getString("startTime"), rs.getString("endTime"), rs.getString("status"));
        
        return staffBid;
    }
    
}
