package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface User {

    UserDTO createNewUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    @Transactional
    List<UserDTO> saveAllUsers(List<UserDTO> list);

}
