package com.example.wallet.Controllers;

import com.example.wallet.Dtos.TransactionDTO;
import com.example.wallet.Services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transactions")
public class TransactionController {

    private final TransactionService transaction;

    public TransactionController(TransactionService transaction) {
        this.transaction = transaction;
    }

    @PostMapping("/{walletId}/transactions")
    public ResponseEntity<TransactionDTO> createTransaction(@Valid @PathVariable TransactionDTO transactionDTO){
        TransactionDTO createTransaction = transaction.createNewTransaction(transactionDTO);
        return new ResponseEntity<>(createTransaction, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getAllTransaction(){
        List<TransactionDTO> listOfAllTransactions = transaction.getAllTransactions();
        return ResponseEntity.ok(listOfAllTransactions);
    }
}
