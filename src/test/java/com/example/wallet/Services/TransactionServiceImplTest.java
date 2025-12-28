package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Enum.BillCategory;
import com.example.wallet.Enum.BillType;
import com.example.wallet.Models.User;
import com.example.wallet.Repositories.TransactionRepository;
import com.example.wallet.Repositories.UserRepository;
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
class TransactionServiceImplTest {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        transactionRepository.deleteAll();
    }

    @Transactional
    @Test
    void createNewTransaction() {
        User user = new User();
        user.setName("Yahya");
        user.setEmail("yahaya32@gmail.com");
        User newUser = userRepository.save(user);

        WalletDTO wallet = new WalletDTO();
        wallet.setName("wallet 1 " + newUser.getName());
        wallet.setUserId(newUser.getId());
        wallet.setBalance(new BigDecimal("400.09"));
        WalletDTO savedWallet = walletService.createNewWalletForUser(user);

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setWalletId(savedWallet.getId());
        transactionDTO.setType(BillType.ACCOMMODATION);
        transactionDTO.setBillCategory(BillCategory.MONTHLY);;
        transactionDTO.setAmount(new BigDecimal("300"));
        transactionDTO.setDate(LocalDate.now());
        transactionDTO.setDescription("transferring month December");

        TransactionDTO newTransaction = transactionService.createNewTransaction(transactionDTO);

        assertNotNull(newTransaction);
        assertEquals(BillType.ACCOMMODATION, newTransaction.getType());
        assertEquals("yahaya32@gmail.com", user.getEmail());
        assertEquals("wallet 1 " + newUser.getName(), savedWallet.getName());
        assertEquals("transferring month December", newTransaction.getDescription());
        assertEquals(LocalDate.now(),newTransaction.getDate());
        assertEquals(new BigDecimal("300"), newTransaction.getAmount());
    }

    @Transactional
    @Test
    void testToViewAllTransactionsMade(){
        User user = new User();
        user.setName("Yahya");
        user.setEmail("yahaya32@gmail.com");
        User newUser = userRepository.save(user);

        WalletDTO wallet = new WalletDTO();
        wallet.setName("wallet 1 " + newUser.getName());
        wallet.setUserId(newUser.getId());
        wallet.setBalance(new BigDecimal("400.09"));
        WalletDTO savedWallet = walletService.createNewWalletForUser(user);

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setAmount(new BigDecimal("390.00"));
        transactionDTO.setDate(LocalDate.now());
        transactionDTO.setType(BillType.ACCOMMODATION);
        transactionDTO.setBillCategory(BillCategory.YEARLY);
        transactionDTO.setWalletId(savedWallet.getId());
        List<TransactionDTO> savedListOfTransaction = transactionService.saveAllTransactions(List.of(transactionDTO));

        assertNotNull(savedListOfTransaction);
        assertEquals("wallet 1 " + newUser.getName(), savedWallet.getName());
        assertEquals(new BigDecimal("400.09"), wallet.getBalance());
        assertEquals(new BigDecimal("390.00"), transactionDTO.getAmount());
        assertEquals("Yahya", newUser.getName());
        assertEquals("yahaya32@gmail.com", newUser.getEmail());
        assertEquals(LocalDate.now(), transactionDTO.getDate());

    }
}