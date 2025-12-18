package com.example.wallet.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    private String billCategory;
    private String type;
    private BigDecimal amount;
    private String description;
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(String billCategory, Wallet wallet,
                       String  type, BigDecimal amount, String description, LocalDate date) {
        this.billCategory = billCategory;
        this.wallet = wallet;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Transaction(Long id, String billCategory,
                       Wallet wallet, String type, BigDecimal amount,
                       String description, LocalDate date) {
        this.id = id;
        this.billCategory = billCategory;
        this.wallet = wallet;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long walletId) {
        this.id = walletId;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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
                "id=" + id +
                ", billCategory=" + billCategory +
                ", wallet=" + wallet +
                ", type=" + type +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
