package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices userServices;


    @Test
    void testToVerifyNewUserCreated() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Musa");
        userDTO.setEmail("MusaHAfiz@gmail.com");
        UserDTO user1 = userServices.createNewUser(userDTO);

        assertNotNull(userDTO);
        assertEquals("Musa", user1.getName());
        assertEquals("MusaHAfiz@gmail.com", user1.getEmail());
    }

    @Test
    void testToViewAllUsersCreated(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Musa");
        userDTO.setEmail("MusaHAfiz@gmail.com");

        UserDTO userDTO2 = new UserDTO();
        userDTO.setName("Musa");
        userDTO.setEmail("MusaHAfiz@gmail.com");

        userServices.saveAllUsers(List.of(userDTO, userDTO2));

        List<UserEntity> viewUsers = userServices.getAllUser();

        assertNotNull(viewUsers);
        assertEquals(2, viewUsers.size());
    }
}