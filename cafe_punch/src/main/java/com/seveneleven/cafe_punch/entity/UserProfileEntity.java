package com.seveneleven.cafe_punch.entity;

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

    // Get Profile
    public List<UserProfile> viewUserProfile()
    {
        // sql statement to get all user Accounts
        List<UserProfile> results = jdbcTemplate.query("SELECT * FROM userprofiles", new UserProfileMapper());
        return results;
    }

    public UserProfile getProfileByID(int profileID){
        List<UserProfile> results = jdbcTemplate.query("SELECT * FROM userprofiles WHERE profileID = ?", new UserProfileMapper(), profileID);

        if(results.size() > 0){
            return results.get(0);
        } else {
            return null;
        }
    }

    // Create User Profile
    public boolean createProfile(UserProfile userProfile){

        // UserAccount to be insert into the database

        boolean result = jdbcTemplate.update("INSERT INTO userprofiles (profileName,permissionType) VALUES (?,?)",
                                            userProfile.getProfileName(),
                                            userProfile.getPermissionType()) != 0;
        return result;
    }

    // Update Profile
    public boolean updateProfile(UserProfile userProfile)
    {
        int result = jdbcTemplate.update("UPDATE userprofiles SET profileName=?, permissionType=? WHERE profileID=?",
                                        userProfile.getProfileName(),
                                        userProfile.getPermissionType(),
                                        userProfile.getProfileID());
        
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }

    // Suspend UserAccount
    public boolean suspendAccount(int profileID){

        int result = jdbcTemplate.update("DELETE FROM userprofiles WHERE profileID=?", profileID);

        if (result > 0){
            return true;
        } else {
            return false;
        }
    }

    
}
