package com.seveneleven.cafe_punch.models;

public class Staff {
    String empID;
    String role;
    String firstName;
    String lastName;
    int maxWorkSlot;
    int availableWorkSlot;


    public Staff() {
    }
    
    public Staff(String empID, String role, String firstName, String lastName, int maxWorkSlot, int availableWorkSlot) {
        this.empID = empID;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
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
