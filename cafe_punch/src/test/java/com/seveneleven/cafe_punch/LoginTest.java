package com.seveneleven.cafe_punch;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seveneleven.cafe_punch.entity.UserAccountEntity;

@SpringBootTest
public class LoginTest {
    @Autowired
    UserAccountEntity userAccountEntity;

    @Test
    @DisplayName("User Admin Login Test")
    public void LoginAsAdmin(){
        assertTrue(userAccountEntity.validateCredentials("admin", "123456", "Admin"));
    }

    @Test
    @DisplayName("Cafe Owner Login Test")
    public void LoginAsCafeOwner(){
        assertTrue(userAccountEntity.validateCredentials("A-001", "123456", "Owner"));
    }

    @Test
    @DisplayName("Cafe Manager Login Test")
    public void LoginAsCafeManager(){
        assertTrue(userAccountEntity.validateCredentials("M-001", "123456", "Manager"));
    }

    @Test
    @DisplayName("Cafe Staff Login Test")
    public void LoginAsCafeStaff(){
        assertTrue(userAccountEntity.validateCredentials("test-01", "123456", "Staff"));
    }

    @Test
    @DisplayName("Invalid Login Test")
    public void InvalidLogin(){
        assertFalse(userAccountEntity.validateCredentials("aaaa", "123", "Admin"));
    }
    
}
