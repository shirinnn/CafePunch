package com.seveneleven.cafe_punch.entity;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seveneleven.cafe_punch.models.WorkSlot;
import com.seveneleven.cafe_punch.models.WorkSlotMapper;

@Repository
public class WorkSlotEntity {
    
    // see application.properties file to get the detail on the mysql connection
    @Autowired
    DataSource dataSource;

    // Simplifies the use of JDBC and help avoid common errors.
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<WorkSlot> viewWorkSlot(){
        List<WorkSlot> result = jdbcTemplate.query("SELECT * FROM workslots", new WorkSlotMapper());

        return result;
    }

    public WorkSlot getWSByID(int wsID){
        List<WorkSlot> results = jdbcTemplate.query("SELECT * FROM workslots WHERE wsID = ?", new WorkSlotMapper(), wsID);

        if(results.size() > 0){
            return results.get(0);
        } else {
            return null;
        }
    }

    public List<WorkSlot> searchWorkSlot(String date){
        List<WorkSlot> results = jdbcTemplate.query("SELECT * FROM workslots WHERE date LIKE ?", new WorkSlotMapper(),
                                                            "%"+ date +"%");
        return results;
    }

    public boolean createWorkSlot(WorkSlot workslot){

        // UserAccount to be insert into the database

        boolean result = jdbcTemplate.update("INSERT INTO workslots (date,startTime,endTime,noOfCashier,noOfChef,noOfWaiter) VALUES (?,?,?,?,?,?)",
                                            workslot.getDate(),
                                            workslot.getStartTime(),
                                            workslot.getEndTime(),
                                            workslot.getNoOfCashier(),
                                            workslot.getNoOfChef(),
                                            workslot.getNoOfWaiter()) != 0;
        return result;
    }

    public boolean updateWorkSlot(WorkSlot workslot)
    {
        int result = jdbcTemplate.update("UPDATE workslots SET date=?, startTime=?, endTime=?, noOfCashier=?, noOfChef=?, noOfWaiter=? WHERE wsID=?",
                                        workslot.getDate(),
                                        workslot.getStartTime(),
                                        workslot.getEndTime(),
                                        workslot.getNoOfCashier(),
                                        workslot.getNoOfChef(),
                                        workslot.getNoOfWaiter(),
                                        workslot.getWsID());
        
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteWorkslot(int wsID){

        int result = jdbcTemplate.update("DELETE FROM workslots WHERE wsID=?", wsID);

        if (result > 0){
            return true;
        } else {
            return false;
        }
    }


}
