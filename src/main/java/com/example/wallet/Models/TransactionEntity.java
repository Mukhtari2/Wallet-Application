package com.example.wallet.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity

public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long walletId;
    @ManyToOne
    @JoinColumn(name = "wallet_entity_id")
    private WalletEntity walletEntity;
    private String billCategory;
    private String type;
    private BigDecimal amount;
    private String description;
    private LocalDate date;

    public TransactionEntity() {
    }

    public TransactionEntity(String billCategory, WalletEntity walletEntity,
                             String  type, BigDecimal amount, String description, LocalDate date) {
        this.billCategory = billCategory;
        this.walletEntity = walletEntity;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public TransactionEntity(Long walletId, String billCategory,
                             WalletEntity walletEntity, String type, BigDecimal amount,
                             String description, LocalDate date) {
        this.walletId = walletId;
        this.billCategory = billCategory;
        this.walletEntity = walletEntity;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public WalletEntity getWalletEntity() {
        return walletEntity;
    }

    public void setWalletEntity(WalletEntity walletEntity) {
        this.walletEntity = walletEntity;
    }

    public String getBillCategory() {
        return billCategory;
    }

    public void setBillCategory(String billCategory) {
        this.billCategory = billCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "walletId=" + walletId +
                ", billCategory=" + billCategory +
                ", walletEntity=" + walletEntity +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
