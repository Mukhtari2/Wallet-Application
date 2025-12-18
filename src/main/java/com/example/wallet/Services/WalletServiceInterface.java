package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;

import java.util.List;

public interface WalletServiceInterface {
    WalletDTO createNewWalletForUser(Long userId, WalletDTO walletDTO);
    List<WalletDTO> listAllWalletForUser();

}
