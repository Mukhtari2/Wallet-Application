package com.example.wallet.Services;

import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.WalletEntity;

import java.util.List;

public interface User {
    List<UserEntity> getUsers();

    List<WalletEntity> createWalletForUser();
}
