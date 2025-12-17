package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Arrays;
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
            userServices.createNewUser(userDTO);

            UserDTO userDTO2 = new UserDTO();
            userDTO.setName("Isah");
            userDTO.setEmail("IsahHAfiz@gmail.com");
            userServices.createNewUser(userDTO2);

            UserDTO userDTO3 = new UserDTO();
            userDTO.setName("Joy");
            userDTO.setEmail("JoyMakinde23@rocketmail.com");
            userServices.createNewUser(userDTO3);

            UserDTO userDTO4 = new UserDTO();
            userDTO.setName("amos");
            userDTO.setEmail("amog2@gmail.com");
//            userServices.createNewUser(userDTO4);

        userServices.saveAllUsers(List.of(userDTO, userDTO2,  userDTO3, userDTO4));

        List <UserDTO> viewUsers = userServices.getAllUser();

        assertNotNull(viewUsers);viewUsers.contains(userDTO3);
        System.out.println(viewUsers.getFirst());
        System.out.println(viewUsers.get(1));
        System.out.println(viewUsers.get(2));
        System.out.println(viewUsers.get(3));
        assertEquals(6, viewUsers.size());
        assertEquals("Isah", viewUsers.get(0).getName());
        assertEquals("IsahHAfiz@gmail.com", viewUsers.get(0).getEmail() );
    }
}