package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.User;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Repositories.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final UserService userService;

    @Override
    public WalletDTO createNewWalletForUser(Long userId, String walletName) {
        User userIdToCreateWallet = userService.findByUserId(userId);
        if (userIdToCreateWallet == null) {
            throw new EntityNotFoundException("No user id available to create wallet");
        }
        Wallet wallet = new Wallet();
        wallet.setId(wallet.getId());
        wallet.setName(walletName);
        wallet.setUser(userIdToCreateWallet);
        Wallet saveWallet = walletRepository.save(wallet);
        return mapToWalletUserDTO(saveWallet);
    }

    private WalletDTO mapToWalletUserDTO(Wallet wallet) {
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(wallet.getId());
        walletDTO.setName(wallet.getName());
        walletDTO.setBalance(wallet.getBalance());
        walletDTO.setUserId(wallet.getUserId().getId());
        return walletDTO;
    }

    public List<WalletDTO> saveAllWallets (List<WalletDTO> dtoList){
        List<Wallet> saveWallet = new ArrayList<>();
        for (WalletDTO dto : dtoList){
            User user = userService.findByUserId(dto.getUserId());
            if(user == null) {
                throw new EntityNotFoundException("No user found with the id " + dto.getUserId());
            }
                Wallet wallet = new Wallet();
                wallet.setId(dto.getId());
                wallet.setName(dto.getName());
                wallet.setBalance(dto.getBalance());
                wallet.setUser(user);
                saveWallet.add(wallet);
        }
        List<Wallet> walletList = walletRepository.saveAll(saveWallet);

        List<WalletDTO> dtoWalletList = new ArrayList<>();
        for (Wallet savedWallet : walletList){
            dtoWalletList.add(mapToWalletUserDTO(savedWallet));
        }
        return dtoWalletList;
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

    @Override
    public Wallet findByWalletId(Long walletId) {
        Wallet wallet = new Wallet();
        wallet.setId(walletId);
        return wallet;
    }


}

