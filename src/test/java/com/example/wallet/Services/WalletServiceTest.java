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

    @BeforeEach
    void setUp(){
        walletRepository.deleteAll();
    }


    @Test
    void createNewWalletForUser() {
        WalletDTO walletDTO = new WalletDTO();
        UserEntity userEntity = new UserEntity();
        walletDTO.setName("Monday");
        walletDTO.setUserName(userEntity.setName(walletDTO.getName()));
        WalletDTO wallet1 = walletService.createNewWalletForUser(walletDTO);

        assertNotNull(walletDTO);
        assertEquals("Monday", wallet1.getName());
    }
}