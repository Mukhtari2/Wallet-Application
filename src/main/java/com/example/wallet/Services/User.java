package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface User {

    UserDTO createNewUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    @Transactional
    List<UserEntity> saveAllUsers(List<UserDTO> list);
    UserEntity mapToWalletEntity(UserDTO userWalletDTO);
    UserEntity mapToUser(UserDTO userDTO);
    UserDTO mapToUserDTO(UserEntity user);
    UserDTO mapToWalletTransaction(UserEntity user);
}
