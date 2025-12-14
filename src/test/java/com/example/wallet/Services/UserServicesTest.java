package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class UserServicesTest {

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        userRepository.deleteAll();
    }

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