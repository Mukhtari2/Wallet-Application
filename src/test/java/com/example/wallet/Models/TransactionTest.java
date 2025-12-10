package com.example.wallet.Models;

import com.example.wallet.Enum.Categories;
import com.example.wallet.Enum.TransactionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    Transaction transaction = new Transaction();

    @Test
    void toVerifyTheBillCategory() {
        transaction.setBillCategory(Categories.RENT);
        Categories category = transaction.getBillCategory();
        assertEquals(Categories.RENT, category);
    }

    @Test
    void toVerifyWalletType() {
        transaction.setType(TransactionType.DEBIT);
        TransactionType walletType =  transaction.getType();
        assertEquals(TransactionType.DEBIT, walletType);
    }

    @Test
    void toVerifyTheAmount() {
        try {
            transaction.setAmount(8);
        } catch (IllegalStateException e){
            System.err.printf("%nException: %s%n", e);
        }
        double amount = transaction.getAmount();
        assertEquals(8.0, amount);
    }

    @Test
    void toVerifyWalletDescription() {
        transaction.setDescription("Occupational Wallet");
        String walletDescription = transaction.getDescription();
        assertEquals("Occupational Wallet", walletDescription);
    }

}