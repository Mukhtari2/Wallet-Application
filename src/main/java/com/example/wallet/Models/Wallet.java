package com.example.wallet.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userId;
    private String name;
    private BigDecimal balance;


    public Wallet() {
    }

    public Wallet(UserEntity userId, String name, BigDecimal balance) {
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }

    public Wallet(Long id, UserEntity userId, String name, BigDecimal balance) {
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

    public UserEntity getUser() {
        return userId;
    }

    public void setUser(UserEntity userEntity) {
        this.userId = userEntity;
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
        return "Wallet{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
