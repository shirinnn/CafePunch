package com.seveneleven.cafe_punch.data;

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

    public List<UserAccount> viewUserAccounts() {
        // sql statement to get all user Accounts
        List<UserAccount> results = jdbcTemplate.query("SELECT * FROM useraccounts LEFT JOIN userprofiles ON useraccounts.profileID=userprofiles.profileID", new UserAccountMapper());
        return results;
    }
}
