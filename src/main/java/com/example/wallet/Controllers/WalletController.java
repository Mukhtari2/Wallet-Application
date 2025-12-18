package com.example.wallet.Controllers;


import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Services.WalletServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet")
public class WalletController {
    @Autowired
    private final WalletServiceInterface wallet;

    public WalletController(WalletServiceInterface wallet) {
        this.wallet = wallet;
    }

    @PostMapping("/{userId}/wallet")
    public WalletDTO createWalletForUser( @RequestBody WalletDTO walletDTO){
        return wallet.createNewWalletForUser(walletDTO.getUserId(), walletDTO);

    }
    @GetMapping
    public List<WalletDTO> getListOfAllWallet(){
        return wallet.listAllWalletForUser();
    }
}
