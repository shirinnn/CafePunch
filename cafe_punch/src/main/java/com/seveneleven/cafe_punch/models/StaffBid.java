package com.seveneleven.cafe_punch.models;

public class StaffBid {
    int bID;
    String empID;
    String firstName;
    String lastName;
    String role;
    int availableWorkSlot;
    int wsID;
    String date;
    String startTime;
    String endTime;
    String status;

    public StaffBid() {
    }
    public StaffBid(int bID, String empID, String firstName, String lastName, String role, int availableWorkSlot, int wsID, String date, String startTime, String endTime, String status) {
        this.bID = bID;
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.availableWorkSlot = availableWorkSlot;
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getAvailableWorkSlot() {
        return availableWorkSlot;
    }
    public void setAvailableWorkSlot(int availableWorkSlot) {
        this.availableWorkSlot = availableWorkSlot;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    
}
