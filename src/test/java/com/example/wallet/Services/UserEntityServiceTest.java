package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
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
class UserEntityServiceTest {

    @Autowired
    private UserService userServices;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
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
        assertEquals("musahafiz@gmail.com", user1.getEmail());
    }

    @Test
    void testToViewAllUsersCreated() throws IllegalStateException {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Musa");
        userDTO.setEmail("MusaHAfiz@gmail.com");

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Isah");
        userDTO2.setEmail("IsahHAfiz@gmail.com");

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Joy");
        userDTO3.setEmail("JoyMakinde23@rocketmail.com");

        UserDTO userDTO4 = new UserDTO();
        userDTO4.setName("amos");
        userDTO4.setEmail("amog2@gmail.com");

        userServices.saveAllUsers(List.of(userDTO, userDTO2, userDTO3, userDTO4));

        List<UserDTO> viewUsers = userServices.getAllUsers();

        assertNotNull(viewUsers);
        assertEquals(4, viewUsers.size());
        assertEquals("Isah", viewUsers.get(1).getName());
        assertEquals("joymakinde23@rocketmail.com", viewUsers.get(2).getEmail());
    }

    @Test
    void testToVerifiedEmptyNameEntry(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("   ");
        userDTO.setEmail("MusaHAfiz@gmail.com");

        UserDTO saveEmptyName = userServices.createNewUser(userDTO);
        assertNull(saveEmptyName.getName());
    }
}