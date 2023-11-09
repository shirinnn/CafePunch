package com.seveneleven.cafe_punch.models;

public class UserAccount {
    String empID;
    String firstName;
    String lastName;
    String email;
    String gender;
    String password;
    int profileID;
    String status;
    
    public UserAccount() {
    }

    public UserAccount(String empID, String firstName, String lastName, String email, String gender, String password, int profileID, String status) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.profileID = profileID;
        this.status = status;
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
    public int getProfileID() {
        return profileID;
    }

    public String getStatus() {
        return status;
    }

    

    @Override
    public String toString() {
        return "UserAccount [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
                + email + ", gender=" + gender + ", password=" + password + ", profileName=" + profileID + "]";
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfileID(int profileID) {
        this.profileID = profileID;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}



