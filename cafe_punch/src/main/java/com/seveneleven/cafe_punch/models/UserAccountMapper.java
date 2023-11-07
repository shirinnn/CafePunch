package com.seveneleven.cafe_punch.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserAccountMapper implements RowMapper<UserAccount> {

    @Override
    public UserAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
        // get result set
        // create a new useraccount object
        // return it

        UserAccount userAccount = new UserAccount(rs.getString("empID"), rs.getString("firstName"), rs.getString("lastName"), 
                                    rs.getString("email"), rs.getString("gender"), rs.getString("password"), rs.getString("profileName"), rs.getString("status"));

        return userAccount;
        
    }
    
}
