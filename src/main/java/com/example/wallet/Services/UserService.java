package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Models.User;
import com.example.wallet.Repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class UserService implements UserServiceInterface {

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
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        User saveNewUser = userRepository.save(user);
        return mapToUserEntity(saveNewUser);
    }

    private UserDTO mapToUserEntity(User newUser) {
        return UserDTO.builder()
                .id(newUser.getId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .build();

    }

    @Transactional
    public List<UserDTO> saveAllUsers(List<UserDTO> userDTOS) {
      List<User> userEntities = new ArrayList<>();
      for (UserDTO dto : userDTOS){
          User user =  new User();
          user.setName(dto.getName());
          user.setEmail(dto.getEmail());
          userEntities.add(user);
      }
      List<User> saveNewUserEntities = userRepository.saveAll(userEntities);
      List<UserDTO> savedUserDto = new ArrayList<>();
        for(User user : saveNewUserEntities){
            savedUserDto.add(mapToUserDTO(user));
        }
      return savedUserDto;
    }


    @Override
    @Transactional()
    public List<UserDTO> getAllUsers() {
        List<User> userEntities = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userEntities){
            userDTOList.add(mapToUserDTO(user));
        }
        return userDTOList;
    }

//    @Override
//    public boolean verifyToken(String token) {
//        Optional<VerificationToken> verificationTokenOpt = tokenRepository.findByToken(token);
//
//        if (verificationTokenOpt.isEmpty()) {
//            return false;
//        }
//        VerificationToken verificationToken = verificationTokenOpt.get();
//
//        if (verificationToken.isExpired()) {
//            tokenRepository.delete(verificationToken); // Clean up expired token
//            return false;
//        }
//        User user = verificationToken.getUser();
//        user.setEnabled(true);
//        userRepository.save(user);
//
//        tokenRepository.delete(verificationToken);
//
//        return true;
//
//    }

    public UserDTO mapToUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

}

