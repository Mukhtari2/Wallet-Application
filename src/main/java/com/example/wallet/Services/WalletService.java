package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;

import java.util.List;

public interface WalletService {
    WalletDTO createNewWalletForUser(Long userId, String walletName);
    List<WalletDTO> listAllWalletForUser();

}
