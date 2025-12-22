package com.example.wallet.Controllers;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Services.UserServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
public class UserController {
    private final UserServiceInterface user;


    public UserController(UserServiceInterface user) {
        this.user = user;
    }

    @PostMapping("/new_users")
    public ResponseEntity<UserDTO> createUser(@giot Valid @RequestBody UserDTO userDTO){
        UserDTO createdUser = user.createNewUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }


    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsersCreated(){
        List<UserDTO> users = user.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
