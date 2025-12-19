package com.example.wallet.Controllers;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Models.Transaction;
import com.example.wallet.Services.TransactionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transactions")
public class TransactionController {
    @Autowired
    private final TransactionServiceInterface transaction;

    public TransactionController(TransactionServiceInterface transaction) {
        this.transaction = transaction;
    }

    @PostMapping("/{walletId}/transactions")
    public TransactionDTO createTransaction(@PathVariable Long walletId, @RequestBody TransactionDTO dto){
        return transaction.createNewTransaction(walletId, dto);
    }


    @GetMapping
    public List<TransactionDTO> getAllTransaction(){
        return transaction.getAllTransactions();
    }
}
