package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Enum.Status;
import com.example.wallet.Models.User;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
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
    private WalletService walletService;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;


    @BeforeEach
    void setUp(){
        walletRepository.deleteAll();
        userRepository.deleteAll();
    }


    @Test
    void testToCreateNewWalletForUser() {
            User user = new User();
            user.setName("Abu");
            user.setEmail("ZbbyMicheal23@gmail.com");

            assertEquals(0, userRepository.findAll().size());
            User newUser = userRepository.save(user);
            assertEquals(1, userRepository.findAll().size());

            WalletDTO walletDTO = new WalletDTO();
            walletDTO.setName("wallet 1 " + newUser.getName());
            walletDTO.setUserId(newUser.getId());
            walletDTO.setBalance(new BigDecimal("300.00"));

            assertEquals(0, walletRepository.findAll().size());
            WalletDTO newWallet = walletService.createNewWalletForUser(user);
            assertEquals(1, walletRepository.findAll().size());

            assertNotNull(walletDTO);
            assertEquals("wallet 1 " + newUser.getName(), newWallet.getName());
            assertEquals(user.getId(), newWallet.getUserId());
            assertEquals("Abu", user.getName());
    }

    @Transactional
    @Test
    void testToViewAllWalletCreated(){
        User user = new User();
        user.setName("Abu");
        user.setEmail("ZbbyMicheal23@gmail.com");
        user.setStatus(Status.INACTIVE);

        User user2 = new User();
        user2.setEmail("MusaDanladi21@gmail.com");
        user2.setName("Musa") ;
        user2.setStatus(Status.INACTIVE);

        userRepository.saveAll(List.of(user, user2));

        entityManager.flush();

        WalletDTO wallet1 = new WalletDTO();
        wallet1.setName("Nino wallet");
        wallet1.setBalance(new BigDecimal("9000.00"));
        wallet1.setUserId(user.getId());

        WalletDTO wallet2 = new WalletDTO();
        wallet2.setName("Binance");
        wallet2.setBalance(new BigDecimal("45000.00"));
        wallet2.setUserId(user2.getId());


       walletService.saveAllWallets(List.of(wallet1, wallet2));

        List<WalletDTO> savedWallets = walletService.listAllWalletForUser();

        assertNotNull(savedWallets);
        assertEquals(2, savedWallets.size());
        assertEquals("Nino wallet", savedWallets.getFirst().getName());
        assertEquals("musadanladi21@gmail.com", user2.getEmail());
        assertEquals(new BigDecimal("9000.00"), savedWallets.getFirst().getBalance());

    }
}