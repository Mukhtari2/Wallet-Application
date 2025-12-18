package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WalletService implements WalletServiceInterface{
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userServices;


    @Override
    public WalletDTO createNewWalletForUser(Long userId, WalletDTO dto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("No user available for the wallet"));
        Wallet wallet = new Wallet();
        wallet.setId(dto.getId());
        wallet.setName(dto.getName());
        wallet.setUser(userEntity);
        Wallet saveWallet = walletRepository.save(wallet);
        return mapToWalletUserDTO(saveWallet);


    }

    private WalletDTO mapToWalletUserDTO(Wallet wallet) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setUserId(wallet.getUser().getId());
        walletDTO.setName(wallet.getName());
        return walletDTO;
    }

    @Override
    public List<WalletDTO> listAllWalletForUser() {
        List<Wallet> walletEntities = walletRepository.findAll();
        List<WalletDTO> walletDTOs = new ArrayList<>();
        for (Wallet wallet : walletEntities){
            WalletDTO listOfWalletDto = mapToWalletUserDTO(wallet);
            walletDTOs.add(listOfWalletDto);
        }
        return walletDTOs;
    }

}
