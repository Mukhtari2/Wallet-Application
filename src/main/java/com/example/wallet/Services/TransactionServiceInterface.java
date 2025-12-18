package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;

import java.util.List;

public interface TransactionServiceInterface {
    List<TransactionDTO> listAllTransaction();
    TransactionDTO createNewTransaction(Long walletId, TransactionDTO dto);
}
