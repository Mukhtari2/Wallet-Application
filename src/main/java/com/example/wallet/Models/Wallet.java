package com.example.wallet.Models;

import jakarta.persistence.*;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userEntity;
    private String name;


    public Wallet() {
    }

    public Wallet(UserEntity userEntity, String name) {
        this.userEntity = userEntity;
        this.name = name;
    }

    public Wallet(Long id, UserEntity userEntity, String name) {
        this.id = id;
        this.userEntity = userEntity;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return userEntity;
    }

    public void setUser(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WalletEntity{" +
                "id=" + id +
                ", userEntity=" + userEntity +
                ", userId='" + name + '\'' +
                '}';
    }
}
