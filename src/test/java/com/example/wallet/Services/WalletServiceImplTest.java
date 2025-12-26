package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Data
@ActiveProfiles("test")
class WalletServiceImplTest {

    @Autowired
    private WalletServiceImpl walletServiceImpl;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserService userService;

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

            UserDTO newUser = userService.createNewUser(userDTO);

            WalletDTO walletDTO = new WalletDTO();
            walletDTO.setName("Binance" );
            walletDTO.setUserId(newUser.getId());

            assertNotNull(newUser.getId());
            WalletDTO newWallet = walletServiceImpl.createNewWalletForUser(newUser.getId(), "Binance");

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
        UserDTO newUser = userService.createNewUser(user1);

        WalletDTO wallet1   = new WalletDTO();
        wallet1.setName("Nino wallet");
        wallet1.setBalance(new BigDecimal(9000.00));
        wallet1.setUserId(newUser.getId());

        UserDTO user2 = new UserDTO();
        user2.setEmail("MusaDanladi21@gmail.com");
        user2.setName("Musa") ;
        UserDTO newUser2 = userService.createNewUser(user2);

        WalletDTO wallet2 = new WalletDTO();
        wallet2.setName("Binance");
        wallet2.setBalance(new BigDecimal(45000.00));
        wallet2.setUserId(newUser2.getId());

       walletServiceImpl.saveAllWallets(List.of(wallet1, wallet2));

        List<WalletDTO> savedWallets = walletServiceImpl.listAllWalletForUser();

        assertNotNull(savedWallets);
        assertEquals(2, savedWallets.size());
        assertEquals("Nino wallet", savedWallets.getFirst().getName());
        assertEquals("musadanladi21@gmail.com", user2.getEmail());
        assertEquals(new BigDecimal("9000.00"), savedWallets.getFirst().getBalance());

    }
}