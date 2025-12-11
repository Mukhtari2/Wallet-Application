package com.example.wallet.Models;

import jakarta.persistence.*;

@Entity
@Table
public class WalletEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "user_sequence"
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private String userId;

    public WalletEntity() {
    }

    public WalletEntity(UserEntity userEntity, String userId) {
        this.userEntity = userEntity;
        this.userId = userId;
    }

    public WalletEntity(Long id, UserEntity userEntity, String userId) {
        this.id = id;
        this.userEntity = userEntity;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
                "id=" + id +
                ", userEntity=" + userEntity +
                ", userId='" + userId + '\'' +
                '}';
    }
}
