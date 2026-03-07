package com.example.wallet.Repositories;

import com.example.wallet.Models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Optional<Wallet> findById(Long id);

    @Query("SELECT w FROM Wallet w JOIN FETCH w.userId")
    List<Wallet> findAllWithUsers();
}
