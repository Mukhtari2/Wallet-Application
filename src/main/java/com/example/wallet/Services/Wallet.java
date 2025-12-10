package com.example.wallet.Services;

import com.example.wallet.Models.WalletEntity;

import java.util.List;

public interface Wallet {
    List<WalletEntity> createWalletForUser();
    List<WalletEntity> listAllWalletForUser();
}
