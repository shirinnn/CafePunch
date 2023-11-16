package com.seveneleven.cafe_punch.entity;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seveneleven.cafe_punch.models.StaffBid;
import com.seveneleven.cafe_punch.models.StaffBidMapper;
import com.seveneleven.cafe_punch.models.WorkSlot;
import com.seveneleven.cafe_punch.models.WorkSlotMapper;


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
                                    
        return result;
    }

    public boolean assignSlot(String empID, int wsID, String role){

        boolean result;

        boolean InsertResult = jdbcTemplate.update("INSERT INTO staffbids (empID, wsID, status) VALUES (?,?,'Assigned')",
                                            empID, wsID) != 0;

        // Update available slot of the staff 
        if (InsertResult){
            boolean UpdateStaffsResult = jdbcTemplate.update("UPDATE staffs SET availableWorkSlot=availableWorkSlot-1 WHERE empID=?", empID)!=0;
            if(UpdateStaffsResult){
                if (role.equals("Cashier"))
                    result = jdbcTemplate.update("UPDATE workslots SET noOfCashier=noOfCashier-1 WHERE wsID=?", wsID)!=0;
                else if(role.equals("Chef"))
                    result = jdbcTemplate.update("UPDATE workslots SET noOfChef=noOfChef-1 WHERE wsID=?", wsID)!=0;
                else if(role.equals("Waiter"))
                    result = jdbcTemplate.update("UPDATE workslots SET noOfWaiter=noOfWaiter-1 WHERE wsID=?", wsID)!=0;
                else
                    result = false;
            }
            else
                result = false;
        }
        else
            result = false;
                                    
        return result;
    }

    public List<StaffBid> viewBidsByID(String empID)
    {
        // sql statement to get all user Accounts
        List<StaffBid> results = jdbcTemplate.query("SELECT * FROM staffbids LEFT JOIN workslots ON staffbids.wsID=workslots.wsID LEFT JOIN staffs ON staffbids.empID=staffs.empID LEFT JOIN useraccounts ON staffbids.empID=useraccounts.empID WHERE staffbids.empID=?", new StaffBidMapper(), empID);
        return results;
    }

    public List<StaffBid> searchBidsByStatus(String empID, String status)
    {
        // sql statement to get all user Accounts
        List<StaffBid> results = jdbcTemplate.query("SELECT * FROM staffbids LEFT JOIN workslots ON staffbids.wsID=workslots.wsID LEFT JOIN staffs ON staffbids.empID=staffs.empID LEFT JOIN useraccounts ON staffbids.empID=useraccounts.empID WHERE staffbids.empID=? AND status=?", new StaffBidMapper(), empID, status);
        return results;
    }

    public List<StaffBid> searchBidsReviewByStatus(String status)
    {
        // sql statement to get all user Accounts
        List<StaffBid> results = jdbcTemplate.query("SELECT * FROM staffbids LEFT JOIN workslots ON staffbids.wsID=workslots.wsID LEFT JOIN staffs ON staffbids.empID=staffs.empID LEFT JOIN useraccounts ON staffbids.empID=useraccounts.empID WHERE staffbids.status=?", new StaffBidMapper(), status);
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

    public List<StaffBid> viewAllBids(){
        List<StaffBid> result = jdbcTemplate.query("SELECT * FROM staffbids LEFT JOIN workslots ON staffbids.wsID=workslots.wsID LEFT JOIN staffs ON staffbids.empID=staffs.empID LEFT JOIN useraccounts ON staffbids.empID=useraccounts.empID", new StaffBidMapper());
        return result;
    }

    public boolean approveBids(String empID, int bID, int wsID, String role){

        // Get no of WorkSlot based on role
         WorkSlot isSlotOpen = jdbcTemplate.query("SELECT * FROM workslots WHERE wsID=?", new WorkSlotMapper(), wsID).get(0);

        // Check if there is slot available for the staff
        if (role.equals("Cashier")){
            if (isSlotOpen.getNoOfCashier() > 0){
                // Proceed with the approval
                int rowBidUpdated = jdbcTemplate.update("UPDATE staffbids SET status='Approved' WHERE bID=?", bID);
                int rowWsUpdated = jdbcTemplate.update("UPDATE workslots SET noOfCashier=noOfCashier-1 WHERE wsID=?", wsID);

                // also update the staff's availableSlot if approval updated successfully
                if (rowBidUpdated > 0 && rowWsUpdated > 0){
                    int rowStaffUpdated = jdbcTemplate.update("UPDATE staffs SET availableWorkSlot=availableWorkSlot-1 WHERE empID=?", empID);
                    if (rowStaffUpdated > 0){
                        return true;
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
        } else if (role.equals("Waiter")){
            if (isSlotOpen.getNoOfWaiter() > 0){
                // Proceed with the approval
                int rowBidUpdated = jdbcTemplate.update("UPDATE staffbids SET status='Approved' WHERE bID=?", bID);
                int rowWsUpdated = jdbcTemplate.update("UPDATE workslots SET noOfWaiter=noOfWaiter-1 WHERE wsID=?", wsID);

                // also update the staff's availableSlot if approval updated successfully
                if (rowBidUpdated > 0 && rowWsUpdated > 0){
                    int rowStaffUpdated = jdbcTemplate.update("UPDATE staffs SET availableWorkSlot=availableWorkSlot-1 WHERE empID=?", empID);
                    if (rowStaffUpdated > 0){
                        return true;
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
        } else if (role.equals("Chef")){
            if (isSlotOpen.getNoOfWaiter() > 0){
                // Proceed with the approval
                int rowBidUpdated = jdbcTemplate.update("UPDATE staffbids SET status='Approved' WHERE bID=?", bID);
                int rowWsUpdated = jdbcTemplate.update("UPDATE workslots SET noOfChef=noOfChef-1 WHERE wsID=?", wsID);

                // also update the staff's availableSlot if approval updated successfully
                if (rowBidUpdated > 0 && rowWsUpdated > 0){
                    int rowStaffUpdated = jdbcTemplate.update("UPDATE staffs SET availableWorkSlot=availableWorkSlot-1 WHERE empID=?", empID);
                    if (rowStaffUpdated > 0){
                        return true;
                    }
                    else
                        return false;
                }
                else
                    return false;
            }
        }
        return false;
    }

    public boolean rejectBid(int bID){
        int result = jdbcTemplate.update("UPDATE staffbids SET status='Rejected' WHERE bID=?", bID);

        if (result > 0)
            return true;
        else
            return false;
    }
}
