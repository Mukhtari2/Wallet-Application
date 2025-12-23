package com.example.wallet.Repositories;

import com.example.wallet.Models.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<UserToken, Long> {
}
