package com.example.wallet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User
        extends JpaRepository<com.example.wallet.Models.User, Long> {
}
