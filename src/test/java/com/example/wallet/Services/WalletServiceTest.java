package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class WalletServiceTest {

    @Autowired
    private WalletService walletService;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserService userServices;

    @Autowired
    private UserRepository userRepository;


    @BeforeEach
    void setUp(){
        walletRepository.deleteAll();
    }


    @Test
    void testToCreateNewWalletForUser() {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail("ZubbyMicheal23@gmail.com");
            userDTO.setName("Zubby");

            UserDTO newUser = userServices.createNewUser(userDTO);

            WalletDTO walletDTO = new WalletDTO();
            walletDTO.setName("Binance");
            walletDTO.setUserId(newUser.getId());


            WalletDTO newWallet = walletService.createNewWalletForUser(newUser.getId(), walletDTO.getName());

            assertNotNull(walletDTO);
            assertEquals("Binance", newWallet.getName());
            assertEquals(newUser.getId(), newWallet.getUserId());
    }
}