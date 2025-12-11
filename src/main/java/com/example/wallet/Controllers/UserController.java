package com.example.wallet.Controllers;

import com.example.wallet.Models.UserEntity;
import com.example.wallet.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet_user")
public class UserController {
    @Autowired
    private final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<UserEntity> getUsers(){
        return userServices.getUsers();
    }

    @PostMapping
    public void  createUser(@RequestBody UserEntity userEntity){
        userServices.createNewUser();
    }
}
