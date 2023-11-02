package com.seveneleven.cafe_punch.models;

public class UserProfile {
    int profileID;
    String profileName;
    String permissionType;

    public UserProfile() {
    }
    
    public UserProfile(int profileID, String profileName, String permissionType) {
        this.profileID = profileID;
        this.profileName = profileName;
        this.permissionType = permissionType;
    }

    public int getProfileID() {
        return profileID;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getPermissionType() {
        return permissionType;
    }

    
}
