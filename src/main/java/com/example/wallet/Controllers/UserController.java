package com.example.wallet.Controllers;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Services.User;
import com.example.wallet.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wallet_user")
public class UserController {
    @Autowired
    private final User user;

    public UserController(User user) {
        this.user = user;
    }

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return user.createNewUser(new UserDTO());
    }

    @PostMapping
    public List<UserDTO> saveAllUsers(@RequestBody List<UserDTO> list){
        return user.saveAllUsers(list);
    }
    @GetMapping
    public List<UserEntity> getAllUsersCreated(){
        return user.getAllUser();
    }
}
