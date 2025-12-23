package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.UserTokenDTO;
import com.example.wallet.Enum.Status;
import com.example.wallet.Models.UserToken;
import com.example.wallet.Repositories.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TokenService implements TokenServiceInterface{

    private final TokenRepository tokenRepository;
    private final EmailServiceInterface emailServiceInterface;

    public TokenService(TokenRepository tokenRepository, EmailServiceInterface emailServiceInterface) {
        this.tokenRepository = tokenRepository;
        this.emailServiceInterface = emailServiceInterface;
    }

    @Override
    public UserTokenDTO createToken(UserDTO createdUser) {
        String token = UUID.randomUUID().toString();
        UserToken userToken = new UserToken();
        userToken.setUserId(createdUser.getId());
        userToken.setStatus(Status.INACTIVE);
        userToken.setToken(token);
        UserToken saveToken = tokenRepository.save(userToken);

        if(saveToken.getId() != null){
            System.out.println("Send email o the user");
            emailServiceInterface.sendEmail(token,createdUser.getEmail());

        }
        return mapToUserToken(saveToken);

    }

    private UserTokenDTO mapToUserToken(UserToken saveToken) {
        return UserTokenDTO.builder()
                .id(saveToken.getId())
                .userId(saveToken.getUserId())
                .status(saveToken.getStatus())
                .token(saveToken.getToken())
                .build();
    }
}
