package com.example.wallet.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    User user = new User("Abu", "Abu23@Gmail.com");

    @Test
    void toGetNameOfUser() {
        String name = user.getName();
        assertEquals("Abu", name);
    }

    @Test
    void toVerifyEmailOfUser() {
        String emailOfUser = user.getEmail();
        assertEquals("Abu23@Gmail.com", emailOfUser);
    }
}