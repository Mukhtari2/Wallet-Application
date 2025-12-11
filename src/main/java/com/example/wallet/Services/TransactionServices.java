package com.example.wallet.Services;

import com.example.wallet.Models.TransactionEntity;
import com.example.wallet.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServices implements Transaction{
    @Autowired
    private TransactionRepository transactionRepository;


    @Override
    public List<TransactionEntity> listAllTransaction() {
        return List.of();
    }
}
