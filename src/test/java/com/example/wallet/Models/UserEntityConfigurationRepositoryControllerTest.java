package com.example.wallet.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityConfigurationRepositoryControllerTest {
    UserEntity userEntity = new UserEntity("Abu", "Abu23@Gmail.com");

    @Test
    void toGetNameOfUser() {
        String name = userEntity.getName();
        assertEquals("Abu", name);
    }

    @Test
    void toVerifyEmailOfUser() {
        String emailOfUser = userEntity.getEmail();
        assertEquals("Abu23@Gmail.com", emailOfUser);
    }
}