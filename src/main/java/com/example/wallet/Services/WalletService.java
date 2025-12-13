package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
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
    public WalletDTO createNewWalletForUser(WalletDTO walletDTO) {
        return null;
    }

    @Override
    public List<WalletEntity> listAllWalletForUser() {
        return walletRepository.findAll();
    }
}
