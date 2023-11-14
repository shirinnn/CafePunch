package com.seveneleven.cafe_punch.models;

public class Staff {
    String empID;
    String role;
    int maxWorkSlot;
    int availableWorkSlot;


    public Staff() {
    }

    public Staff(String empID, String role, int maxWorkSlot, int availableWorkSlot) {
        this.empID = empID;
        this.role = role;
        this.maxWorkSlot = maxWorkSlot;
        this.availableWorkSlot = availableWorkSlot;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getMaxWorkSlot() {
        return maxWorkSlot;
    }

    public void setMaxWorkSlot(int maxWorkSlot) {
        this.maxWorkSlot = maxWorkSlot;
    }

    public int getAvailableWorkSlot() {
        return availableWorkSlot;
    }

    public void setAvailableWorkSlot(int availableWorkSlot) {
        this.availableWorkSlot = availableWorkSlot;
    }    
    
}
