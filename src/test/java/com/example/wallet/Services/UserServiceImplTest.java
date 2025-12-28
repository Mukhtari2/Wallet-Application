package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Enum.Status;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Data
@ActiveProfiles("test")
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    @BeforeEach
    void setUp() {
        walletRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void testToVerifyNewUserCreated() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Musa");
        userDTO.setEmail("MusaHAfiz@gmail.com");

        assertEquals(0, userRepository.findAll().size());
        UserDTO user1 = userService.createNewUser(userDTO);

        assertEquals(1, userRepository.findAll().size());
        assertNotNull(userDTO);
        assertEquals("Musa", user1.getName());
        assertEquals("musahafiz@gmail.com", user1.getEmail());
    }

    @Test
    void testToViewAllUsersCreated() throws IllegalStateException {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Musa");
        userDTO.setEmail("MusddaHAfiz@gmail.com");

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("Isah");
        userDTO2.setEmail("IsaaahHAfiz@gmail.com");

        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("Joy");
        userDTO3.setEmail("JoyMadakinde23@rocketmail.com");

        UserDTO userDTO4 = new UserDTO();
        userDTO4.setName("amos");
        userDTO4.setEmail("amogac2@gmail.com");

        assertEquals(0, userRepository.findAll().size());
        userService.saveAllUsers(List.of(userDTO, userDTO2, userDTO3, userDTO4));

        assertEquals(4, userRepository.findAll().size());
        List<UserDTO> viewUsers = userService.getAllUsers();

        assertNotNull(viewUsers);
        assertEquals(4, viewUsers.size());
        assertEquals("Isah", viewUsers.get(1).getName());
        assertEquals("joymadakinde23@rocketmail.com", viewUsers.get(2).getEmail());
    }

    @Test
    void testToViewAnotherWallet(){
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Yunus");
        userDTO.setEmail("YunusDadday@gmail.com");
        userDTO.setStatus(Status.INACTIVE);

        assertEquals(0, userRepository.findAll().size() );
        UserDTO newUser = userService.createNewUser(userDTO);
        assertEquals(1, userRepository.findAll().size() );
        assertEquals(1, walletRepository.findAll().size());
        userService.createAnotherWallet(newUser.getId());
        assertEquals(2, walletRepository.findAll().size());
        assertNotNull(userDTO);
        assertEquals(Status.INACTIVE, userDTO.getStatus());

    }

}