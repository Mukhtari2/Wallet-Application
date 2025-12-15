package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;

import java.util.List;

public interface User {

    UserDTO createNewUser(UserDTO userDTO);

    List<UserEntity> getAllUser();

    List<UserEntity> saveAllUsers(List<UserDTO> list);
}
