package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;

import java.util.List;

public interface UserServiceInterface {

    UserDTO createNewUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();


}
