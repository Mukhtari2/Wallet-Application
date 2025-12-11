package com.example.wallet.Dtos;

public class WalletDTO {
    private Long id;
    private UserDTO userName;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUserName() {
        return userName;
    }

    public void setUserName(UserDTO userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
