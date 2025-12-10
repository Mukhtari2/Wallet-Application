package com.example.wallet.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    Wallet wallet = new Wallet("Emeka", "75");

    @Test
    void toVerifyName() {
        String name = wallet.getName();
        assertEquals("Emeka", name);
    }

    @Test
    void getUserId() {
    }
}