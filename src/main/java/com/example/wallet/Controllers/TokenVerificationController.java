package com.example.wallet.Controllers;

import com.example.wallet.Services.TokenVerificationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenVerificationController {

    @Autowired
    private final TokenVerificationServiceInterface tokenVerificationServiceInterface;

    @PostMapping
    public ResponseEntity<String> verify(@RequestParam ("token") String token){
        if (tokenVerificationServiceInterface.verify(token)){
            return ResponseEntity.ok("token is verified successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid token");

    }
}
