package com.example.wallet.Services;

import com.example.wallet.Repositories.WalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WalletServiceInterfaceTest {

    @Autowired
    private WalletServiceInterface walletServiceInterface;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserService userServices;

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