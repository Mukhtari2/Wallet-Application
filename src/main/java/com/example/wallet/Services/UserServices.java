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

//    @Transactional
    @Override
    public List<UserEntity> saveAllUsers(List<UserDTO> userDTOS) {
        List<UserEntity> userEntities = new ArrayList<>();
        for(UserDTO userDTO : userDTOS){
            UserEntity userEntity = new UserEntity(userDTO.getName(), userDTO.getEmail());
            userEntities.add(userEntity);
        }
        return userRepository.saveAll(userEntities);

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

