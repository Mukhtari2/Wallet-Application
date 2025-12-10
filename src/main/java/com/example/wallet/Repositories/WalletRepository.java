package com.example.wallet.Repositories;

import com.example.wallet.Models.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository
        extends JpaRepository<WalletEntity, Long> {
}
