package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService implements Wallet{
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;


    @Override
    public WalletDTO createNewWalletForUser(WalletDTO walletDTO) {
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setUser(userServices.mapToUser(walletDTO.getUserName()));
        walletEntity.setName(walletDTO.getName());
        WalletEntity saveWallet = walletRepository.save(walletEntity);
        return mapToWalletUser(saveWallet);

    }

    private WalletDTO mapToWalletUser(WalletEntity walletEntity) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(walletEntity.getId());
        walletDTO.setUserName(userServices.mapToUserDTO(walletEntity.getUser()));
        walletDTO.setName(walletEntity.getName());
        return walletDTO;
    }

    @Override
    public List<WalletEntity> listAllWalletForUser() {
        return walletRepository.findAll();
    }

    public WalletEntity mapToTransactionDTO(WalletDTO walletDTO) {
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setId(walletDTO.getId());
        walletEntity.setName(walletDTO.getName());
        walletEntity.setUser(userServices.mapToWalletDTO(walletDTO.getUserName()));
        return walletEntity;
    }
}
