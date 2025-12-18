package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Repositories.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionServiceTest {
    @Autowired
    private TransactionServiceInterface transactionServices;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userServices;

    @Autowired
    private WalletService walletService;

    @BeforeEach
    void setUp() {
        transactionRepository.deleteAll();
    }

    @Test
    void createNewTransaction() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Yahya");
        userDTO.setEmail("yahaya32@gmail.com");
        UserDTO newUser = userServices.createNewUser(userDTO);

        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setName("Binance");
        walletDTO.setUserId(newUser.getId());
        WalletDTO savedWallet = walletService.createNewWalletForUser(walletDTO.getUserId(), walletDTO);

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setType("Bank transaction");
        transactionDTO.setBillCategory("FOOD");;
        transactionDTO.setAmount(new BigDecimal("300"));
        transactionDTO.setDate(LocalDate.now());
        transactionDTO.setDescription("transferring money for the feeding of month December");
        transactionDTO.setWalletId(newUser.getId());

        TransactionDTO newTransaction = transactionServices.createNewTransaction(savedWallet.getUserId(), transactionDTO);

        assertNotNull(newTransaction);
    }
}