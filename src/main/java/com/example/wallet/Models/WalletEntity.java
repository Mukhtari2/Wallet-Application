package com.example.wallet.Models;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class WalletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity user;
    private String name;


    public WalletEntity() {
    }

    public WalletEntity(UserEntity user, String name) {
        this.user = user;
        this.name = name;
    }

    public WalletEntity(Long id, UserEntity user, String name) {
        this.id = id;
        this.user = user;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
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
                ", userEntity=" + user +
                ", userId='" + name + '\'' +
                '}';
    }
}
