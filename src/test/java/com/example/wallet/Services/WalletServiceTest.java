package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Repositories.WalletRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WalletServiceTest {

    @Autowired
    private WalletService walletService;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserServices userServices;

    @BeforeEach
    void setUp(){
        walletRepository.deleteAll();
    }


//    @Test
//    void createNewWalletForUser() {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setEmail("ZubbyMicheal23@gmail.com");
//        userDTO.setName("Zubby");
//        UserDTO newUser = userServices.createNewUser(userDTO);
//
//        WalletDTO walletDTO = new WalletDTO();
//        walletDTO.setName("Binance");
//        walletDTO.setUserName(newUser);
//
//        WalletDTO newWallet = walletService.createNewWalletForUser(walletDTO);
//
//        assertNotNull(walletDTO);
//        assertEquals(walletDTO.getName(), newWallet.getName());
//        assertEquals(walletDTO.getUserName().getName(), newWallet.getUserName().getName());
//    }
}