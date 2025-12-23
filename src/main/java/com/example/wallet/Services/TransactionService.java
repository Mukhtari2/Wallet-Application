package com.example.wallet.Services;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Models.Transaction;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Repositories.TransactionRepository;
import com.example.wallet.Repositories.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService implements TransactionServiceInterface {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletServiceInterface walletServiceInterface;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    @Transactional
    public TransactionDTO createNewTransaction(Long walletId, TransactionDTO dto) {
        Wallet wallet  = walletRepository.findById(walletId)
                .orElseThrow(()-> new EntityNotFoundException("No Wallet available for the transaction"));
        Transaction transaction = new Transaction();
        transaction.setWallet(wallet);
        transaction.setType(dto.getType());
        transaction.setAmount(dto.getAmount());
        transaction.setBillCategory(dto.getBillCategory());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());
        Transaction savedTransaction = transactionRepository.save(transaction);
        return mapToTransactionDTO(savedTransaction);
    }

    private TransactionDTO mapToTransactionDTO(Transaction transaction) {
        TransactionDTO dto = new TransactionDTO();
        dto.setWalletId(transaction.getWallet().getId());
        dto.setType(transaction.getType());
        dto.setAmount(transaction.getAmount());
        dto.setBillCategory(transaction.getBillCategory());
        dto.setDate(transaction.getDate());
        dto.setDescription(transaction.getDescription());
        return dto;
    }

    @Override
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactionEntities = transactionRepository.findAll();
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        for (Transaction transaction : transactionEntities){
            TransactionDTO transactionDTO = mapToTransactionDTO(transaction);
            transactionDTOS.add(transactionDTO);
        }
        return transactionDTOS;
    }

    public List<TransactionDTO> saveAllTransactions(List<TransactionDTO> dtoList){
        List<Transaction> savedTransaction = new ArrayList<>();

        for (TransactionDTO dto : dtoList){
            Wallet wallet = walletRepository.findById(dto.getWalletId()).
                    orElseThrow(() -> new EntityNotFoundException
                            ("No wallet found with the id " + dto.getWalletId()));

            Transaction transaction = new Transaction();
            transaction.setWallet(wallet);
            transaction.setDescription(dto.getDescription());
            transaction.setType(dto.getType());
            transaction.setBillCategory(dto.getBillCategory());
            transaction.setAmount(dto.getAmount());
            transaction.setDate(dto.getDate());
            savedTransaction.add(transaction);
        }
        List<Transaction> savedEntities = transactionRepository.saveAll(savedTransaction);

        List<TransactionDTO> transactionDTOList = new ArrayList<>();
        for (Transaction transactionEntity : savedEntities){
            transactionDTOList.add(mapToTransactionDTO(transactionEntity));
        }
        return transactionDTOList;
    }

}
