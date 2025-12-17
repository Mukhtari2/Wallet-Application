package com.example.wallet.Controllers;


import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Services.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public WalletDTO createWalletForUser(@RequestBody WalletDTO walletDTO){
        return wallet.createNewWalletForUser(walletDTO);

    }
    @GetMapping
    public List<WalletDTO> getListOfAllWallet(){
        return wallet.listAllWalletForUser();
    }
}
