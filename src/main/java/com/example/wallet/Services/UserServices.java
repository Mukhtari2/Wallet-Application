package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

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
        UserEntity saveUser = userRepository.save(userEntity);
        return mapToUserDTO(saveUser);
    }

    private UserDTO mapToUserDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<UserEntity> saveAllUsers(List<UserDTO> userDTOS) {
        List<UserEntity> userEntities = new ArrayList<>();
        for(UserDTO userDTO : userDTOS){
            UserEntity userEntity = mapToSaveAllDTO(userDTO);
            userEntities.add(userEntity);
        }
        return userRepository.saveAll(userEntities);

    }

    private UserEntity mapToSaveAllDTO(UserDTO userDto){
            return  new UserEntity(userDto.getName(), userDto.getEmail());
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





}

