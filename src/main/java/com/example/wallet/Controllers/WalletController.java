package com.example.wallet.Controllers;

import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet")
public class WalletController {
    @Autowired
    private final UserServices userServices;

    public WalletController(UserServices userServices) {
        this.userServices = userServices;
    }
    @GetMapping
    public List<WalletEntity> getWalletCreated(){
        return  userServices.createWalletForUser();
    }
}
