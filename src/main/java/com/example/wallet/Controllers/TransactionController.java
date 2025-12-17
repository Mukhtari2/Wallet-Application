package com.example.wallet.Controllers;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Models.TransactionEntity;
import com.example.wallet.Services.Transaction;
import com.example.wallet.Services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet_transactions")
public class TransactionController {
    @Autowired
    private final Transaction transaction;

    public TransactionController(Transaction transaction) {
        this.transaction = transaction;
    }

    @PostMapping("save")
    public TransactionDTO createTransaction(@RequestBody TransactionDTO transactionDTO){
        return transaction.createNewTransaction(transactionDTO);
    }


    @GetMapping
    public List<TransactionDTO> getAllTransaction(){
        return transaction.listAllTransaction();
    }
}
