package com.example.wallet.Services;

import com.example.wallet.Models.WalletEntity;

import java.util.List;

public class WalletService implements Wallet{
    @Override
    public List<WalletEntity> createWalletForUser() {
        return List.of();
    }

    @Override
    public List<WalletEntity> listAllWalletForUser() {
        return List.of();
    }
}
