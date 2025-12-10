package com.example.wallet.Services;

import com.example.wallet.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesTest {

    @Autowired
    private UserServices userServices;

    @MockitoBean
    private UserRepository userRepository;

    @Test
    void toVerifyAllUsersCreated() {
        List result = userServices.getUsers();
        assertArrayEquals(result.toArray( ), result);
    }

    @Test
    void createWalletForUser() {
    }
}