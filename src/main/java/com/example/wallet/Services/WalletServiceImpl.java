package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.User;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Repositories.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    public WalletDTO createNewWalletForUser(User user) {
        Long counter = walletRepository.count() + 1;
        Wallet wallet = new Wallet();
        wallet.setId(wallet.getId());
        wallet.setName("wallet " + counter + " " + user.getName());
        wallet.setUser(user);
        wallet.setBalance(new BigDecimal("0.00"));
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
    public List<WalletDTO> saveAllWallets (List<WalletDTO> dtoList, User userId){
        List<Wallet> saveWallet = new ArrayList<>();
        for (WalletDTO dto : dtoList){
                Wallet wallet = new Wallet();
                wallet.setId(dto.getId());
                wallet.setName(dto.getName());
                wallet.setBalance(dto.getBalance());
                wallet.setUser(userId);
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
        return walletRepository.findById(walletId).orElseThrow();
    }

}

