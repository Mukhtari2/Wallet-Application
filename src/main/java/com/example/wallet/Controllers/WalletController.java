package com.example.wallet.Controllers;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Services.UserServices;
import com.example.wallet.Services.Wallet;
import com.example.wallet.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet")
public class WalletController {
    @Autowired
    private final Wallet wallet;

    public WalletController(Wallet wallet) {
        this.wallet = wallet;
    }

    @PostMapping
    public WalletDTO createWalletForUser(){
        return wallet.createNewWalletForUser(new WalletDTO());
    }
    @GetMapping
    public List<WalletEntity> getListOfAllWallet(){
        return wallet.listAllWalletForUser();
    }
}
