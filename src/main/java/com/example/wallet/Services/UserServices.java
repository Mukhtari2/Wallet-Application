package com.example.wallet.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserServices implements User {

    @GetMapping
    @Override
    public List<com.example.wallet.Models.User> getUsers() {
        return List.of(
                new com.example.wallet.Models.User(
                        1L,
                        "Mukhtar",
                        "Mukhtara4sr@gmail.com"
                )
        );
    }
}

