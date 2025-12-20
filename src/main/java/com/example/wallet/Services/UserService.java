package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceInterface {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository ) {
        this.userRepository = userRepository;
    }


    @Override
    @Transactional
    public UserDTO createNewUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new EntityExistsException("Email already registered");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userDTO.getEmail());
        UserEntity saveNewUserEntity = userRepository.save(userEntity);
        return mapToUserEntity(saveNewUserEntity);
    }

    private UserDTO mapToUserEntity(UserEntity newUserEntity) {
        UserDTO dto = new UserDTO(newUserEntity.getId(), newUserEntity.getName(), newUserEntity.getEmail());
        return dto;
    }

    @Transactional
    public List<UserDTO> saveAllUsers(List<UserDTO> userDTOS) {
      List<UserEntity> userEntityEntities = new ArrayList<>();
      for (UserDTO dto : userDTOS){
          UserEntity userEntity =  new UserEntity();
          userEntity.setName(dto.getName());
          userEntity.setEmail(dto.getEmail());
          userEntityEntities.add(userEntity);
      }
      List<UserEntity> saveNewUserEntityEntities = userRepository.saveAll(userEntityEntities);
      List<UserDTO> savedUserDto = new ArrayList<>();
        for(UserEntity userEntity : saveNewUserEntityEntities){
            savedUserDto.add(mapToUserDTO(userEntity));
        }
      return savedUserDto;
    }


    @Transactional
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> userEntityEntities = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserEntity userEntity : userEntityEntities){
            userDTOList.add(mapToUserDTO(userEntity));
        }
        return userDTOList;
    }

    public UserDTO mapToUserDTO(UserEntity userEntity) {
        UserDTO dto = new UserDTO();
        dto.setId(userEntity.getId());
        dto.setName(userEntity.getName());
        dto.setEmail(userEntity.getEmail());
        return dto;
    }

}

