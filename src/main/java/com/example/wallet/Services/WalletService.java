package com.example.wallet.Services;

import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WalletService implements Wallet{
    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<WalletEntity> createWalletForUser() {
        return List.of();
    }

    @Override
    public List<WalletEntity> listAllWalletForUser() {
        return List.of();
    }
}
