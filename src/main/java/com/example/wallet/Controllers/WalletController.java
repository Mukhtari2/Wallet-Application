package com.example.wallet.Controllers;


import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.Wallet;
import com.example.wallet.Services.WalletServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet")
public class WalletController {

    private final WalletServiceInterface wallet;

    public WalletController(WalletServiceInterface wallet) {
        this.wallet = wallet;
    }

    @PostMapping("/{userId}/wallet")
    public ResponseEntity<WalletDTO> createWalletForUser(@Valid @RequestBody WalletDTO walletDTO){
        WalletDTO createWallet = wallet.createNewWalletForUser(walletDTO.getUserId(), walletDTO.getName());
        return new ResponseEntity<>(createWallet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WalletDTO>> getListOfAllWallet(){
        List<WalletDTO> listOfCreatedWallet = wallet.listAllWalletForUser();
        return ResponseEntity.ok(listOfCreatedWallet);
    }
}
