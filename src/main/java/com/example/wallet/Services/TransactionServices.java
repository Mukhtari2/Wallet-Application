package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.TransactionEntity;
import com.example.wallet.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServices implements Transaction{
    @Autowired
    private TransactionRepository transactionRepository;

    @
    Autowired
    private  WalletService walletService;

    @Override
    public List<TransactionDTO> listAllTransaction() {
        List<TransactionEntity> transactionEntities = transactionRepository.findAll();
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (TransactionEntity transaction : transactionEntities){
            TransactionDTO transactionDTO = mapToTransactionDTO(transaction);
            transactionDTOS.add(transactionDTO);
        }
        return transactionDTOS;
    }

    @Override
    public TransactionDTO createNewTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setWalletId(transactionDTO.getWalletId());
        transaction.setWalletEntity(walletService.mapToWalletTransaction(transactionDTO.getWallet()));
        transaction.setType(transactionDTO.getType());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setBillCategory(transactionDTO.getBillCategory());
        transaction.setDate(transactionDTO.getDate());
        TransactionEntity createdTransaction = transactionRepository.save(transaction);
        return mapToTransactionDTO(createdTransaction);
    }

    private TransactionDTO mapToTransactionDTO(TransactionEntity transactionEntity) {
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setWalletId(transactionEntity.getWalletId());
        transactionDTO.setWallet(walletService.mapToWalletTransactionDTO(transactionEntity.getWalletEntity()));
        transactionDTO.setType(transactionEntity.getType());
        transactionDTO.setAmount(transactionEntity.getAmount());
        transactionDTO.setBillCategory(transactionEntity.getBillCategory());
        transactionDTO.setDate(transactionEntity.getDate());
        return transactionDTO;
    }

    public TransactionDTO gerTransactionById(Long id){
        TransactionEntity transaction = transactionRepository.findById(id).orElseThrow();
        return mapToTransactionDTO(transaction);
    }

    public List <TransactionDTO> getTransactionByWalletId(Long walletId){
        WalletDTO walletDTO = walletService.getWalletById(walletId);
        List<TransactionEntity> transactionEntities = transactionRepository.findByWalletId(walletDTO);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (TransactionEntity transaction : transactionEntities){
            TransactionDTO transactionDTO = mapToTransactionDTO(transaction);
            transactionDTOS.add(transactionDTO);
        }
        return  transactionDTOS;

    }
}
