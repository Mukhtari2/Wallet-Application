package com.example.wallet.Services;

import com.example.wallet.Dtos.UserDTO;
import com.example.wallet.Dtos.UserTokenDTO;


public interface TokenServiceInterface {
    UserTokenDTO createToken(UserDTO userToken);
}
