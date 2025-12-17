package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices implements User {
    @Autowired
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO createNewUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        UserEntity saveNewUser = userRepository.save(userEntity);
        return mapToUserEntity(saveNewUser);
    }

    private UserDTO mapToUserEntity(UserEntity newUser) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(newUser.getName());
        userDTO.setEmail(newUser.getEmail());
        return userDTO;
    }

    @Transactional
    @Override
    public List<UserDTO> saveAllUsers(List<UserDTO> userDTOS) {
      List<UserEntity> userEntities = new ArrayList<>();
      for (UserDTO dto : userDTOS){
          UserEntity user =  new UserEntity();
          user.setName(dto.getName());
          user.setEmail(dto.getEmail());
          userEntities.add(user);
      }
      List<UserEntity> saveNewUserEntities = userRepository.saveAll(userEntities);
      List<UserDTO> savedUserDto = new ArrayList<>();
        for(UserEntity userEntity : saveNewUserEntities){
            UserDTO userDto = mapToUserDTO(userEntity);
            savedUserDto.add(userDto);
        }
      return savedUserDto;
    }


    public UserEntity mapToWalletEntity(UserDTO userWalletDTO) {
        UserEntity userWalletEntity = new UserEntity();
        userWalletEntity.setId(userWalletDTO.getId());
        userWalletEntity.setName(userWalletDTO.getName());
        userWalletEntity.setEmail(userWalletDTO.getEmail());
        return userWalletEntity;
    }


    public UserDTO mapToWalletTransaction(UserEntity user) {
        UserDTO userWalletDTO = new UserDTO();
        userWalletDTO.setId(user.getId());
        userWalletDTO.setName(user.getName());
        userWalletDTO.setEmail(user.getEmail());
        return userWalletDTO;
    }

    @Transactional
    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (UserEntity user : userEntities){
            UserDTO userDTO = mapToUserDTO(user);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public UserDTO mapToUserDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }


    public UserEntity mapToUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    public UserDTO getUserById(Long id){
        UserEntity userEntity = userRepository.findUserById(id).orElseThrow();
        return mapToUserDTO(userEntity);
    }

}

