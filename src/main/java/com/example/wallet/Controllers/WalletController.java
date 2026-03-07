package com.example.wallet.Controllers;


import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.User;
import com.example.wallet.Services.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/wallet")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/{userId}/wallet")
    public ResponseEntity<WalletDTO> createWalletForUser(@Valid @RequestBody User user){
        WalletDTO createWallet = walletService.createNewWalletForUser(user);
        return new ResponseEntity<>(createWallet, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<WalletDTO>> getListOfAllWallet(){
        List<WalletDTO> listOfCreatedWallet = walletService.listAllWalletForUser();
        return ResponseEntity.ok(listOfCreatedWallet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWallet(@PathVariable("id") Long id) {
        walletService.deleteWalletById(id);
        return ResponseEntity.noContent().build();
    }
}
