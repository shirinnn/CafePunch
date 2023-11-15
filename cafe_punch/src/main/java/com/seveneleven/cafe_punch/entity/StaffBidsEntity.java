package com.seveneleven.cafe_punch.entity;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seveneleven.cafe_punch.models.StaffBid;
import com.seveneleven.cafe_punch.models.StaffBidMapper;


@Repository
public class StaffBidsEntity {
    // see application.properties file to get the detail on the mysql connection
    @Autowired
    DataSource dataSource;

    // Simplifies the use of JDBC and help avoid common errors.
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean createBid(String empID, int wsID, String role){

        boolean result = jdbcTemplate.update("INSERT INTO staffbids (empID, wsID, status) VALUES (?,?,'Pending')",
                                            empID, wsID) != 0;


        // Use below when manager approve bids
        // jdbcTemplate.update("UPDATE staffs SET availableWorkSlot= availableWorkSlot-1 WHERE empID=?",
        //                                 empID);

        // if (role.equals("Cashier"))
        // {
        //     jdbcTemplate.update("UPDATE workslots SET noOfCashier=noOfCashier-1 WHERE wsID=?",
        //                                  empID);
        // } else if(role.equals("Chef")){
        //     jdbcTemplate.update("UPDATE workslots SET noOfChef=noOfChef-1 WHERE wsID=?",
        //                                  empID);
        // } else {
        //     jdbcTemplate.update("UPDATE workslots SET noOfWaiter=noOfWaiter-1 WHERE wsID=?",
        //                                  empID);
        // }
                                    

        return result;
    }

    public List<StaffBid> viewBidsByID(String empID)
    {
        // sql statement to get all user Accounts
        List<StaffBid> results = jdbcTemplate.query("SELECT * FROM staffbids LEFT JOIN workslots ON staffbids.wsID=workslots.wsID WHERE empID=?", new StaffBidMapper(), empID);
        return results;
    }

    public List<StaffBid> searchBidsByStatus(String empID, String status)
    {
        // sql statement to get all user Accounts
        List<StaffBid> results = jdbcTemplate.query("SELECT * FROM staffbids LEFT JOIN workslots ON staffbids.wsID=workslots.wsID WHERE empID=? AND status=?", new StaffBidMapper(), empID, status);
        return results;
    }

    public boolean deleteBid(int bID){

        int result = jdbcTemplate.update("DELETE FROM staffbids WHERE bID=?", bID);

        if (result > 0){
            return true;
        } else {
            return false;
        }
    } 
}
