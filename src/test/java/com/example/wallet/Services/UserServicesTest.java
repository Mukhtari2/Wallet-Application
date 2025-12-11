package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesTest {
    @Autowired
    private  UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @Test
    void ToVerifyCreatedNewUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Musa");
        userDTO.setEmail("Musa@yahoo.com");

        UserDTO createdUser = userServices.createNewUser(userDTO);

        Assertions.assertNotNull(createdUser);
        Assertions.assertEquals(userDTO.getName(), createdUser.getName());
        Assertions.assertEquals(userDTO.getEmail(), createdUser.getEmail());
    }
}