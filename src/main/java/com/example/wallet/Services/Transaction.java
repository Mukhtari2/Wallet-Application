package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Models.TransactionEntity;

import java.util.List;

public interface Transaction {
    List<TransactionEntity> listAllTransaction();
    TransactionDTO createNewTransaction(TransactionDTO transactionDTO);
}
