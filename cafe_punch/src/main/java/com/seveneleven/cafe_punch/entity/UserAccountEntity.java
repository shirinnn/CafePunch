package com.seveneleven.cafe_punch.entity;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserAccountMapper;

@Repository
public class UserAccountEntity {

    // see application.properties file to get the detail on the mysql connection
    @Autowired
    DataSource dataSource;

    // Simplifies the use of JDBC and help avoid common errors.
    @Autowired
    JdbcTemplate jdbcTemplate;

    // For Login
    public boolean validateCredentials(String empID, String password, String loginRole){
        // sql statement 
        boolean result;

        if (!loginRole.equals("Admin")){
            result = !jdbcTemplate.query("SELECT * FROM useraccounts LEFT JOIN userprofiles ON useraccounts.profileID=userprofiles.profileID" + 
                                                    " WHERE empID = ? AND password = ? AND permissionType = ?", new UserAccountMapper(), 
                                                    empID, password, loginRole).isEmpty();
        }
        else{
            if (empID.equals("admin") && password.equals("12345"))
            {
                result = true;
            }
            else{
                result = false;
            }
        }
                    
        return result;
    }

    // For view User Accounts
    public List<UserAccount> viewUserAccounts() {
        // sql statement to get all user Accounts
        List<UserAccount> results = jdbcTemplate.query("SELECT * FROM useraccounts LEFT JOIN userprofiles ON useraccounts.profileID=userprofiles.profileID WHERE status = 'active'", new UserAccountMapper());
        return results;
    }
    
    public UserAccount getUserAccountByID(String empID){
        List<UserAccount> results = jdbcTemplate.query("SELECT * FROM useraccounts WHERE empID = ?", new UserAccountMapper(), empID);

        if(results.size() > 0){
            return results.get(0);
        } else {
            return null;
        }
    }

    // Create User Account
    public boolean createAccount(UserAccount userAccount){

        // UserAccount to be insert into the database

        boolean result = jdbcTemplate.update("INSERT INTO useraccounts (empID,firstName,lastName,email,gender,password,profileID,status) " + 
                                            "VALUES (?,?,?,?,?,?,?,'Active')",
                                            userAccount.getEmpID(),
                                            userAccount.getFirstName(),
                                            userAccount.getLastName(),
                                            userAccount.getEmail(),
                                            userAccount.getGender(),
                                            userAccount.getPassword(),
                                            userAccount.getProfileID()) != 0;
        return result;
    }

    // Update User Account
    public boolean updateAccount(UserAccount userAccount)
    {
        int result = jdbcTemplate.update("UPDATE useraccounts SET firstName=?, lastName=?, email=?, gender=?, profileID=? WHERE empID=?",
                                            userAccount.getFirstName(),
                                            userAccount.getLastName(),
                                            userAccount.getEmail(),
                                            userAccount.getGender(),
                                            userAccount.getProfileID(),
                                            userAccount.getEmpID());
        
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }

    // Suspend UserAccount
    public boolean suspendAccount(String empID){

        int result = jdbcTemplate.update("UPDATE useraccounts SET status='Suspend' WHERE empID=?", empID);

        if (result > 0){
            return true;
        } else {
            return false;
        }
    }
}
