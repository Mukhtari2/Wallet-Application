package com.example.wallet.Services;

import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.User;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;
    private final UserService userService;


    public WalletServiceImpl(WalletRepository walletRepository, @Lazy UserService userService) {
        this.walletRepository = walletRepository;
        this.userService = userService;
    }

    @Override
    public WalletDTO createNewWalletForUser(User user) {
        Long counter = walletRepository.count() + 1;
        Wallet wallet = new Wallet();
        wallet.setId(wallet.getId());
        wallet.setName(String.format("wallet %d %s", counter, user.getName()));
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
    public List<WalletDTO> saveAllWallets (List<WalletDTO> dtoList){
        List<Wallet> saveWallet = new ArrayList<>();
        for (WalletDTO dto : dtoList){
                Wallet wallet = new Wallet();
                wallet.setId(dto.getId());
                wallet.setName(dto.getName());
                wallet.setBalance(dto.getBalance());
                wallet.setUser(userService.findByUserId(dto.getUserId()));
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
        List<Wallet> walletEntities = walletRepository.findAllWithUsers();

        List<WalletDTO> walletDTOs = new ArrayList<>();
        for (Wallet wallet : walletEntities){
            walletDTOs.add(mapToWalletUserDTO(wallet));
        }
        return walletDTOs;
    }


    @Override
    public Wallet findByWalletId(Long walletId) {
        return walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));
    }

    @Override
    @Transactional
    public void deleteWalletById(Long walletId) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found with ID: " + walletId));

        if (wallet.getBalance().compareTo(BigDecimal.ZERO) > 0) {
            throw new IllegalStateException("Cannot delete a wallet with a remaining balance of " + wallet.getBalance() +
                    "please withdraw your balance hen proceed with deletion");
        }

        walletRepository.delete(wallet);
    }


}

