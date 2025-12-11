//package com.example.wallet.Models;
//
//import com.example.wallet.Enum.Categories;
//import com.example.wallet.Enum.TransactionType;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TransactionEntityRepositoryTest {
//    TransactionEntity transactionEntity = new TransactionEntity();
//
//    @Test
//    void toVerifyTheBillCategory() {
//        transactionEntity.setBillCategory(Categories.RENT);
//        Categories category = transactionEntity.getBillCategory();
//        assertEquals(Categories.RENT, category);
//    }
//
//    @Test
//    void toVerifyWalletType() {
//        transactionEntity.setType(TransactionType.DEBIT);
//        TransactionType walletType =  transactionEntity.getType();
//        assertEquals(TransactionType.DEBIT, walletType);
//    }
//
//    @Test
//    void toVerifyTheAmount() {
//        try {
//            transactionEntity.setAmount(8);
//        } catch (IllegalStateException e){
//            System.err.printf("%nException: %s%n", e);
//        }
//        double amount = transactionEntity.getAmount();
//        assertEquals(8.0, amount);
//    }
//
//    @Test
//    void toVerifyWalletDescription() {
//        transactionEntity.setDescription("Occupational Wallet");
//        String walletDescription = transactionEntity.getDescription();
//        assertEquals("Occupational Wallet", walletDescription);
//    }
//
//}