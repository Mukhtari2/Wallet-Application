package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.WalletDTO;
import com.example.wallet.Models.UserEntity;
import com.example.wallet.Models.WalletEntity;
import com.example.wallet.Repositories.UserRepository;
import com.example.wallet.Repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService implements Wallet{
    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public WalletDTO createNewWalletForUser(WalletDTO walletDTO) {
        Optional<UserEntity> userEntity = userRepository.findUserById(walletDTO.getId());
        WalletEntity walletEntity = new WalletEntity();
        walletEntity.setUser(userEntity);
        walletEntity.setName(walletDTO.getName());
        WalletEntity saveWallet = walletRepository.save(walletEntity);
        return mapToWalletUser(saveWallet);

    }

    private WalletDTO mapToWalletUser(WalletEntity walletEntity) {
        UserEntity userEntity = new UserEntity();
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setId(walletEntity.getId());
        walletDTO.setUserName(walletEntity.getUser());
        walletDTO.setName(walletDTO.getName());
        return walletDTO;
    }
//    private UserDTO mapToUserDTO(UserEntity userEntity){
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(userEntity.getId());
//        userDTO.setName(userEntity.getName());
//        userDTO.setEmail(userEntity.getEmail());
//        return userDTO;
//    }
    private UserEntity mapToUserEntity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDTO.getId());
        userEntity.setName(userDTO.getName());
        userEntity.setEmail(userEntity.getEmail());
        return userEntity;
    }

    @Override
    public List<WalletEntity> listAllWalletForUser() {
        return walletRepository.findAll();
    }
}
