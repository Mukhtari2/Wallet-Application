package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Models.Wallet;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions();
    TransactionDTO createNewTransaction(Long walletId);
}
