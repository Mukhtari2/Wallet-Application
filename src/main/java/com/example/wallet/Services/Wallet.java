package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.WalletEntity;

import java.util.List;

public interface Wallet {
    WalletDTO createNewWalletForUser(WalletDTO walletDTO);
    List<WalletEntity> listAllWalletForUser();
    WalletEntity mapToTransactionEntity(WalletDTO walletTransactionDTO);
    WalletDTO mapToTransactionDTO(WalletEntity walletTransactionEntity);
}
