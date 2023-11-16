package com.seveneleven.cafe_punch.entity;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seveneleven.cafe_punch.models.Staff;
import com.seveneleven.cafe_punch.models.StaffMapper;
import com.seveneleven.cafe_punch.models.UserAccount;
import com.seveneleven.cafe_punch.models.UserAccountMapper;

@Repository
public class StaffDetailsEntity {

    // see application.properties file to get the detail on the mysql connection
    @Autowired
    DataSource dataSource;

    // Simplifies the use of JDBC and help avoid common errors.
    @Autowired
    JdbcTemplate jdbcTemplate;

    // For view staff
    public List<UserAccount> viewStaffList() {
        // sql statement to get all user Accounts
        List<UserAccount> results = jdbcTemplate.query("SELECT * FROM useraccounts LEFT JOIN userprofiles ON useraccounts.profileID=userprofiles.profileID WHERE status = 'active'", new UserAccountMapper());
        return results;
    }

    public Staff getStaffByID(String empID){
        List<Staff> results = jdbcTemplate.query("SELECT * FROM staffs LEFT JOIN useraccounts ON staffs.empID=useraccounts.empID WHERE staffs.empID = ?", new StaffMapper(), empID);

        if(results.size() > 0){
            return results.get(0);
        } else {
            return null;
        }
    }

    public boolean updateStaffDetail(Staff staff)
    {
        int result = jdbcTemplate.update("UPDATE staffs SET role=?, maxWorkSlot=?, availableWorkSlot=? WHERE empID=?",
                                        staff.getRole(),
                                        staff.getMaxWorkSlot(),
                                        staff.getAvailableWorkSlot(),
                                        staff.getEmpID());
        
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }

    public List<Staff> viewStaffs(){
        List<Staff> results = jdbcTemplate.query("SELECT * FROM staffs LEFT JOIN useraccounts ON staffs.empID=useraccounts.empID", new StaffMapper());

        return results;
    }

}
