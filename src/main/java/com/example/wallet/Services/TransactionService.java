package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;

import java.util.List;

public interface TransactionService {
    List<TransactionDTO> getAllTransactions();
    TransactionDTO createNewTransaction(Long walletId, TransactionDTO dto);
}
