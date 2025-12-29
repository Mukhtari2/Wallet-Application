package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.UserTokenDTO;
import com.example.wallet.Enum.Status;
import com.example.wallet.Models.User;
import com.example.wallet.Repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final EmailService emailService;
    private final WalletService walletService;


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
        user.setStatus(Status.INACTIVE);
        User saveNewUser = userRepository.save(user);

        if (saveNewUser.getId() != null){
           UserDTO userDtoForToken = mapToUserDTO(saveNewUser);
           UserTokenDTO token = tokenService.createToken(userDtoForToken);
           int createdToken = token.getToken();
           emailService.sendEmail(createdToken, saveNewUser.getEmail());
           walletService.createNewWalletForUser(saveNewUser);
        }else {
            userRepository.delete(saveNewUser);
        }
        return mapToUserEntity(saveNewUser);
    }
    private UserDTO mapToUserEntity(User newUser) {
        return UserDTO.builder()
                .id(newUser.getId())
                .name(newUser.getName())
                .email(newUser.getEmail())
                .status(Status.INACTIVE)
                .build();
    }

    @Transactional
    public List<UserDTO> saveAllUsers(List<UserDTO> userDTOS) {
      List<User> userEntities = new ArrayList<>();
      for (UserDTO dto : userDTOS){
          User user =  new User();
          user.setId(dto.getId());
          user.setName(dto.getName());
          user.setEmail(dto.getEmail());
          user.setStatus(dto.getStatus());
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

    public User findByUserId(long id){
        return userRepository.findById(id).orElseThrow();
    }
    public void createAnotherWallet(Long id) {
        User user = findByUserId(id);
        if (user.getId() != null) {
            walletService.createNewWalletForUser(user);
        } else throw new EntityExistsException("User id does not exist");
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

