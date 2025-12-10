package com.example.wallet.Models;

import jakarta.persistence.*;

@Entity
@Table
public class WalletEntity {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
    private String walletName;
    private String userId;

    public WalletEntity() {
    }

    public WalletEntity(Long id, String name, String userId) {
        this.id = id;
        this.walletName = name;
        this.userId = userId;
    }

    public WalletEntity(String name, String userId) {
        this.walletName = name;
        this.userId = userId;
    }

    public String getName() {
        return walletName;
    }

    public void setName(String name) {
        this.walletName = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "id=" + id +
                ", name='" + walletName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
