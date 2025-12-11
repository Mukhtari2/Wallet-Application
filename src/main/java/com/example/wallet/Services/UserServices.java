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
    @Autowired
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @Override
    public List<UserEntity> getUsers() {
           return List.of(
                   new UserEntity(
                           "Musa",
                           "Musa23@gmail.com"
                   ),
                  new UserEntity(
                "Amos",
                "Amos3@gmail.com"
                  )
           );
    }

    @Override
    public List<WalletEntity> createWalletForUser() {
        return  List.of();
    }

    @Override
    public void createNewUser() {

    }
}

