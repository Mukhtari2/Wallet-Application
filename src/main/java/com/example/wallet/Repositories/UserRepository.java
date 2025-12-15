package com.example.wallet.Repositories;

import com.example.wallet.Models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserById(Long id);
}
