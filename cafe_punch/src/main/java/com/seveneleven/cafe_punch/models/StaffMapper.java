package com.seveneleven.cafe_punch.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StaffMapper implements RowMapper<Staff>{

    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        Staff staff = new Staff(rs.getString("empID"), rs.getString("role"), rs.getInt("maxWorkSlot"), rs.getInt("availableWorkSlot"));

        return staff;
    }
    
}
