package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.User;

import java.util.List;

public interface UserService {

    UserDTO createNewUser(UserDTO userDTO);
    List<UserDTO> saveAllUsers(List<UserDTO> userDTOS);
    List<UserDTO> getAllUsers();
    User findByUserId(long id);
    void createAnotherWallet(Long id);

}
