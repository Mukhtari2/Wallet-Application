package com.example.wallet.Repositories;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
    List<Transaction> findByWalletId(WalletDTO id);
//    boolean existsByWallet(WalletEntity walletEntity);
}
