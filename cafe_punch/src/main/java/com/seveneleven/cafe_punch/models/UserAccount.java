package com.seveneleven.cafe_punch.models;

public class UserAccount {
    String empID;
    String firstName;
    String lastName;
    String email;
    String gender;
    String password;
    String profileName;
    
    public UserAccount() {
    }

    public UserAccount(String empID, String firstName, String lastName, String email, String gender, String password, String profileName) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.profileName = profileName;
    }

    public String getEmpID() {
        return empID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
    public String getPassword() {
        return password;
    }
    public String getProfileID() {
        return profileName;
    }
}


