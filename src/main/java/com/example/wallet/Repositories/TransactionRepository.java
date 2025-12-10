package com.example.wallet.Repositories;

import com.example.wallet.Models.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository
        extends JpaRepository<TransactionEntity, Long> {
}
