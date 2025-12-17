package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return mapToWalletUserDTO(saveWallet);

    }

    private WalletDTO mapToWalletUserDTO(WalletEntity walletEntity) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(walletEntity.getId());
        walletDTO.setUserName(userServices.mapToUserDTO(walletEntity.getUser()));
        walletDTO.setName(walletEntity.getName());
        return walletDTO;
    }

    @Override
    public List<WalletDTO> listAllWalletForUser() {
        List<WalletEntity> walletEntities = walletRepository.findAll();
        List<WalletDTO> walletDTOs = new ArrayList<>();
        for (WalletEntity wallet : walletEntities){
            WalletDTO listOfWalletDto = mapToWalletUserDTO(wallet);
            walletDTOs.add(listOfWalletDto);
        }
        return walletDTOs;
    }

    public WalletEntity mapToWalletTransaction(WalletDTO walletEntityForTransaction) {
        WalletEntity walletTransactionEntity = new WalletEntity();
        walletTransactionEntity.setId(walletEntityForTransaction.getId());
        walletTransactionEntity.setName(walletTransactionEntity.getName());
        walletTransactionEntity.setUser(userServices.mapToWalletEntity(walletEntityForTransaction.getUserName()));
        return walletTransactionEntity;
    }

    public WalletDTO mapToWalletTransactionDTO(WalletEntity walletTransactionEntity) {
        WalletDTO walletTransactionDTO = new WalletDTO();
        walletTransactionDTO.setId(walletTransactionEntity.getId());
        walletTransactionDTO.setName(walletTransactionEntity.getName());
        walletTransactionDTO.setUserName(userServices.mapToWalletTransaction(walletTransactionEntity.getUser()));
        return walletTransactionDTO;
    }

    public WalletDTO getWalletById(Long id){
        WalletEntity walletEntity = walletRepository.findById(id).orElseThrow();
        return mapToWalletUserDTO(walletEntity);
    }
    public WalletDTO getWalletByUserId(Long userId){
        UserDTO userDTO = userServices.getUserById(userId);
        WalletEntity walletEntity = walletRepository.findByUserId(userDTO.getId()).orElseThrow();
        return mapToWalletUserDTO(walletEntity);
    }
}
