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
    public UserEntity createNewUser(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        return userRepository.save(userEntity);
    }

    @Transactional
    @Override
    public List<UserEntity> saveAllUsers(List<UserDTO> userDTOS) {
        List<UserEntity> userEntities = new ArrayList<>();
        for(UserDTO userDTO : userDTOS){
            UserEntity userEntity = new UserEntity(userDTO.getName(), userDTO.getEmail());
            userEntities.add(userEntity);
        }
        return userRepository.saveAll(userEntities);

    }

    @Override
    public UserDTO mapToWalletEntity(UserEntity user) {
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
            UserDTO userDTO = new UserDTO();
            userDTO.setName(user.getName());
            userDTO.setEmail(user.getEmail());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    private List<UserDTO> getAllUserDtos(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (UserEntity entity : userEntities){
            UserDTO userDTO = new UserDTO();
            userDTO.setName(entity.getName());
            userDTO.setEmail(entity.getEmail());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public UserDTO mapToUserDTO(UserEntity user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    @Override
    public UserEntity mapToUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);
    }

    @Override
    public UserEntity mapToWalletDTO(UserDTO userName) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userName.getId());
        userEntity.setName(userName.getName());
        userEntity.setEmail(userName.getEmail());
        return userEntity;
    }
}

