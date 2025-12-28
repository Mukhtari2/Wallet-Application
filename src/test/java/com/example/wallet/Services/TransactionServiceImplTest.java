package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Enum.BillCategory;
import com.example.wallet.Enum.BillType;
import com.example.wallet.Models.User;
import com.example.wallet.Models.Wallet;
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
        User dto = new User();
        dto.setName("Yahya");
        dto.setEmail("yahaya32@gmail.com");
        User newUser = userRepository.save(dto);

        WalletDTO wallet = new WalletDTO();
        wallet.setName("wallet 1 " + newUser.getName());
        wallet.setUserId(newUser.getId());
        WalletDTO savedWallet = walletService.createNewWalletForUser();

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setWalletId(savedWallet.getId());
        transactionDTO.setType(BillType.ACCOMMODATION);
        transactionDTO.setBillCategory(BillCategory.MONTHLY);;
        transactionDTO.setAmount(new BigDecimal("300"));
        transactionDTO.setDate(LocalDate.now());
        transactionDTO.setDescription("transferring month December");


        TransactionDTO newTransaction = transactionService.createNewTransaction(transactionDTO);

        assertNotNull(newTransaction);
        assertEquals(BillType.CABLE_SUBSCRIPTION, newTransaction.getType());
        assertEquals("yahaya32@gmail.com", dto.getEmail());
        assertEquals("wallet 1 " + newUser.getName(), savedWallet.getName());
        assertEquals("transferring month December", newTransaction.getDescription());
        assertEquals(LocalDate.now(),newTransaction.getDate());
        assertEquals(new BigDecimal("300"), newTransaction.getAmount());
        assertEquals(savedWallet.getUserId(), newTransaction.getWalletId());
    }
//
//    @Transactional
//    @Test
//    void testToViewAllTransactionsMade(){
//        UserDTO user1 = new UserDTO();
//        user1.setName("Hafeez Abdallah");
//        user1.setEmail("HafeezAbdallah12@gmail.com");
//        UserDTO saveUser = userServicesImpl.createNewUser(user1);
//
//        WalletDTO wallet1 = new WalletDTO();
//        wallet1.setName("Binance");
//        wallet1.setBalance(new BigDecimal("3000.00"));
//        wallet1.setUserId(saveUser.getId());
//        WalletDTO savedWallet = walletService.createNewWalletForUser(saveUser.getId());
//
//        TransactionDTO transactionDTO = new TransactionDTO();
//        transactionDTO.setAmount(new BigDecimal("390.00"));
//        transactionDTO.setDate(LocalDate.now());
//        transactionDTO.setType(BillType.ACCOMMODATION);
//        transactionDTO.setBillCategory(BillCategory.YEARLY);
//        transactionDTO.setWalletId(savedWallet.getId());
//        List<TransactionDTO> savedListOfTransaction = transactionServiceImpl.saveAllTransactions(List.of(transactionDTO));
//
//        assertNotNull(savedListOfTransaction);
//        assertEquals("Binance", savedWallet.getName());
//        assertEquals(new BigDecimal("3000.00"), wallet1.getBalance());
//        assertEquals(new BigDecimal("390.00"), transactionDTO.getAmount());
//        assertEquals("Hafeez Abdallah", saveUser.getName());
//        assertEquals("hafeezabdallah12@gmail.com", saveUser.getEmail());
//        assertEquals(1, savedWallet.getUserId());
//        assertEquals(LocalDate.now(), transactionDTO.getDate());
//
//    }
}