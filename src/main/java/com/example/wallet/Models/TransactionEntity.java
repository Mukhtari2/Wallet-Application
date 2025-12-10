package com.example.wallet.Models;

import com.example.wallet.Enum.Categories;
import com.example.wallet.Enum.TransactionType;

import java.time.LocalDate;

public class TransactionEntity {

    private Long walletId;
    private Categories billCategory;
    private TransactionType type;
    private double amount;
    private String description;
    private LocalDate date;

    public TransactionEntity() {
    }

    public TransactionEntity(Categories billCategory, TransactionType type,
                             double amount, Long walletId, String description, LocalDate date) {
        this.billCategory = billCategory;
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.description = description;
        this.date = date;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }
    public Long getWalletId() {
        return walletId;
    }




    public void setBillCategory(Categories billCategory) {
        this.billCategory = billCategory;
    }
    public Categories getBillCategory() {
        return billCategory;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
    public TransactionType getType() {
        return type;
    }

    public void setAmount(double amount) {
        if(amount > 0) {
            this.amount = amount;
        }else
            throw new IllegalStateException("Invalid Amount");
    }
    public double getAmount() {
        return amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
