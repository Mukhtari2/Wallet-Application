package com.example.wallet.Services;

import com.example.wallet.Enum.Status;
import com.example.wallet.Models.UserToken;
import com.example.wallet.Repositories.TokenRepository;
import com.example.wallet.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenVerificationService implements TokenVerificationServiceInterface{

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean verify(String token) {
        UserToken userToken = tokenRepository.findByToken(token);
        if (userToken != null) {
            userToken.setStatus(Status.INACTIVE);
            tokenRepository.save(userToken);

            userRepository.findById(userToken.getUserId()).ifPresent(user -> {
                user.setStatus(Status.ACTIVE);
                userRepository.save(user);
            });
            return true;
        }

        return false;
    }

}
