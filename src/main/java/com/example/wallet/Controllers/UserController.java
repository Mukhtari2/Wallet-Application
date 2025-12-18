package com.example.wallet.Controllers;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Services.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    @Autowired
    private final UserServiceInterface user;


    public UserController(UserServiceInterface user) {
        this.user = user;
    }

    @PostMapping("/new_users")
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return user.createNewUser(userDTO);
    }


    @PostMapping("/all_users")
    public List<UserDTO> saveAllUsers(@RequestBody List<UserDTO> userDTOS){
        return user.saveAllUsers(userDTOS);
    }


    @GetMapping()
    public List<UserDTO> getAllUsersCreated(){
        return user.getAllUsers();
    }
}
