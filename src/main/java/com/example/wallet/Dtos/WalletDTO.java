package com.example.wallet.Dtos;

import java.math.BigDecimal;

public class WalletDTO {
    private Long id;
    private Long userId;
    private String name;
    private BigDecimal balance;

    public WalletDTO() {
    }

    public WalletDTO(Long userId, String name, BigDecimal balance) {
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }

    public WalletDTO(Long id, Long userId, String name, BigDecimal balance) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.balance = balance;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "WalletDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
