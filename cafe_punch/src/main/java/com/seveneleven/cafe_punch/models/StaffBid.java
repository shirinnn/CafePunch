package com.seveneleven.cafe_punch.models;

public class StaffBid {
    int bID;
    String empID;
    int wsID;
    String date;
    String startTime;
    String endTime;
    String status;

    public StaffBid() {
    }
    public StaffBid(int bID, String empID, int wsID, String date, String startTime, String endTime, String status) {
        this.bID = bID;
        this.empID = empID;
        this.wsID = wsID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public int getbID() {
        return bID;
    }
    public void setbID(int bID) {
        this.bID = bID;
    }
    public String getEmpID() {
        return empID;
    }
    public void setEmpID(String empID) {
        this.empID = empID;
    }
    public int getWsID() {
        return wsID;
    }
    public void setWsID(int wsID) {
        this.wsID = wsID;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
}
