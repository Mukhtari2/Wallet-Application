package com.example.wallet.Services;

import com.example.wallet.Models.TransactionEntity;

import java.util.List;

public class TransactionServices implements Transaction{
    @Override
    public List<TransactionEntity> listAllTransaction() {
        return List.of();
    }
}
