package com.example.wallet.Services;

import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserServices implements User {
    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @Override
    public List<UserEntity> getUsers() {
           return userRepository.findAll();

    }

    @Override
    public List<WalletEntity> createWalletForUser() {

        return List.of(
                 new WalletEntity(
                        10L,
                        "Binance",
                        "l"
                )
        );
    }
}

