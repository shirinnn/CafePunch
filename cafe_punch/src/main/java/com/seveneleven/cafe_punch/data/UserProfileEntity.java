package com.seveneleven.cafe_punch.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seveneleven.cafe_punch.models.UserProfile;
import com.seveneleven.cafe_punch.models.UserProfileMapper;

@Repository
public class UserProfileEntity {

    // see application.properties file to get the detail on the mysql connection
    @Autowired
    DataSource dataSource;

    // Simplifies the use of JDBC and help avoid common errors.
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserProfile> viewUserProfile()
    {
        // sql statement to get all user Accounts
        List<UserProfile> results = jdbcTemplate.query("SELECT * FROM userprofiles", new UserProfileMapper());
        return results;
    }
    
}
