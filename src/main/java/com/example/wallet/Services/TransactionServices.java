package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Models.TransactionEntity;
import com.example.wallet.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransactionServices implements Transaction{
    @Autowired
    private TransactionRepository transactionRepository;

    @
    Autowired
    private  WalletService walletService;

    @Override
    public List<TransactionEntity> listAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public TransactionEntity createNewTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setWalletId(transactionDTO.getWalletId());
        transaction.setWalletEntity(walletService.mapToTransactionDTO(transactionDTO.getWallet()));
        transaction.setType(transactionDTO.getType());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setBillCategory(transactionDTO.getBillCategory());
        transaction.setDate(transactionDTO.getDate());
        TransactionEntity createdTransaction = transactionRepository.save(transaction);
        return mapToTransactionDTO(createdTransaction);
    }


}
