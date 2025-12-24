package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.UserTokenDTO;
import com.example.wallet.Enum.Status;
import com.example.wallet.Models.UserToken;
import com.example.wallet.Repositories.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final EmailService emailService;

    public TokenServiceImpl(TokenRepository tokenRepository, EmailService emailService) {
        this.tokenRepository = tokenRepository;
        this.emailService = emailService;
    }

    @Override
    public UserTokenDTO createToken(UserDTO createdUser) {
        String token = UUID.randomUUID().toString();
        UserToken userToken = new UserToken();
        userToken.setUserId(createdUser.getId());
        userToken.setStatus(Status.ACTIVE);
        userToken.setToken(token);
        UserToken saveToken = tokenRepository.save(userToken);

        if(saveToken.getId() != null){
            System.out.println("Send email o the user");
            emailService.sendEmail(token,createdUser.getEmail());

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
