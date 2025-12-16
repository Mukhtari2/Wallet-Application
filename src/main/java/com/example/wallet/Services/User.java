package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import jakarta.transaction.Transactional;

import java.util.List;

public interface User {

    UserEntity createNewUser(UserDTO userDTO);

    List<UserDTO> getAllUser();

    @Transactional
    List<UserEntity> saveAllUsers(List<UserDTO> list);
    UserDTO mapToWalletEntity(UserEntity user);
    UserEntity mapToUser(UserDTO userDTO);
    UserDTO mapToUserDTO(UserEntity user);
    UserEntity mapToWalletDTO(UserDTO userName);

}
