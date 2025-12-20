package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;

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

    @Transactional
    @Test
    void createNewTransaction() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("Yahya");
        userDTO.setEmail("yahaya32@gmail.com");
        UserDTO newUser = userServices.createNewUser(userDTO);

        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setName("Binance");
        walletDTO.setUserId(newUser.getId());
        WalletDTO savedWallet = walletService.createNewWalletForUser(walletDTO.getUserId(), walletDTO.getName());

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setWalletId(savedWallet.getId());
        transactionDTO.setType("Bank transaction");
        transactionDTO.setBillCategory("FOOD");;
        transactionDTO.setAmount(new BigDecimal("300"));
        transactionDTO.setDate(LocalDate.now());
        transactionDTO.setDescription("transferring money for the feeding of month December");


        TransactionDTO newTransaction = transactionService.createNewTransaction(savedWallet.getUserId(), transactionDTO);

        assertNotNull(newTransaction);
        assertEquals("Bank transaction", newTransaction.getType());
        assertEquals("yahaya32@gmail.com", newUser.getEmail());
        assertEquals("Binance", savedWallet.getName());
        assertEquals(LocalDate.now(),newTransaction.getDate());
        assertEquals(new BigDecimal("300"), newTransaction.getAmount());
        assertEquals(1, savedWallet.getUserId());
        assertEquals(savedWallet.getUserId(), newTransaction.getWalletId());
    }

    @Transactional
    @Test
    void testToViewAllTransactionsMade(){
        UserDTO user1 = new UserDTO();
        user1.setName("Hafeez Abdallah");
        user1.setEmail("HafeezAbdallah12@gmail.com");
        UserDTO saveUser = userServices.createNewUser(user1);

        WalletDTO wallet1 = new WalletDTO();
        wallet1.setName("Binance");
        wallet1.setBalance(new BigDecimal("3000.00"));
        wallet1.setUserId(saveUser.getId());
        WalletDTO savedWallet = walletService.createNewWalletForUser(saveUser.getId(), wallet1.getName());

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(new BigDecimal("390.00"));
        transactionDTO.setDate(LocalDate.now());
        transactionDTO.setType("Feeding");
        transactionDTO.setBillCategory("Monthly stipends");
        transactionDTO.setWalletId(savedWallet.getId());
        List<TransactionDTO> savedListOfTransaction = transactionService.saveAllTransactions(List.of(transactionDTO));

        assertNotNull(savedListOfTransaction);
        assertEquals("Binance", savedWallet.getName());
        assertEquals(new BigDecimal("3000.00"), wallet1.getBalance());
        assertEquals(new BigDecimal("390.00"), transactionDTO.getAmount());
        assertEquals("Hafeez Abdallah", saveUser.getName());
        assertEquals("HafeezAbdallah12@gmail.com", saveUser.getEmail());
        assertEquals(LocalDate.now(), transactionDTO.getDate());

    }
}