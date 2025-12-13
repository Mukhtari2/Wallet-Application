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
