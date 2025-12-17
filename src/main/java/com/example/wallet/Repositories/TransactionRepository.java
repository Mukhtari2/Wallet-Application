package com.example.wallet.Repositories;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository
        extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByWalletId(WalletDTO id);
}
