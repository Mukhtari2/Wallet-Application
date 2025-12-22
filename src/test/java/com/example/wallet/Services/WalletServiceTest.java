package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            userDTO.setEmail("ZbbyMicheal23@gmail.com");
            userDTO.setName("Zubby") ;

            UserDTO newUser = userServices.createNewUser(userDTO);

            WalletDTO walletDTO = new WalletDTO();
            walletDTO.setName("Binance");
            walletDTO.setUserId(newUser.getId());

            WalletDTO newWallet = walletService.createNewWalletForUser(newUser.getId(), "Binance");

            assertNotNull(walletDTO);
            assertEquals("Binance", newWallet.getName());
            assertEquals(newUser.getId(), newWallet.getUserId());
            assertEquals("Zubby", newUser.getName());
    }

    @Test
    void testToViewAllWalletCreated(){
        UserDTO user1 = new UserDTO();
        user1.setEmail("ZubbyMicheal23@gmail.com");
        user1.setName("Zubby") ;
        UserDTO newUser = userServices.createNewUser(user1);

        WalletDTO wallet1   = new WalletDTO();
        wallet1.setName("Nino wallet");
        wallet1.setBalance(new BigDecimal(9000.00));
        wallet1.setUserId(newUser.getId());

        UserDTO user2 = new UserDTO();
        user2.setEmail("MusaDanladi21@gmail.com");
        user2.setName("Musa") ;
        UserDTO newUser2 = userServices.createNewUser(user2);

        WalletDTO wallet2 = new WalletDTO();
        wallet2.setName("Binance");
        wallet2.setBalance(new BigDecimal(45000.00));
        wallet2.setUserId(newUser2.getId());

       walletService.saveAllWallets(List.of(wallet1, wallet2));

        List<WalletDTO> savedWallets = walletService.listAllWalletForUser();

        assertNotNull(savedWallets);
        assertEquals(2, savedWallets.size());
        assertEquals("Nino wallet", savedWallets.getFirst().getName());
        assertEquals("musadanladi21@gmail.com", user2.getEmail());
        assertEquals(new BigDecimal("9000.00"), savedWallets.getFirst().getBalance());

    }
}