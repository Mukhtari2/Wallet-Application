package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.User;
import com.example.wallet.Models.Wallet;
import java.util.List;

public interface WalletService {
    WalletDTO createNewWalletForUser(User user);
    List<WalletDTO> listAllWalletForUser();
    List<WalletDTO> saveAllWallets(List<WalletDTO> dtoList, User userId);
    Wallet findByWalletId(Long walletId);
}
