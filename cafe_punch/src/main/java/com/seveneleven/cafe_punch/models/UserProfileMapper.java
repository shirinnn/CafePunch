package com.seveneleven.cafe_punch.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserProfileMapper implements RowMapper<UserProfile>{

    @Override
    public UserProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserProfile userProfile = new UserProfile(rs.getInt("profileID"), 
                                    rs.getString("profileName"), 
                                    rs.getString("permissionType"));
        
        return userProfile;
    }
    
}
