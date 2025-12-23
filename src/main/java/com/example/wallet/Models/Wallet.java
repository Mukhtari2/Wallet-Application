package com.example.wallet.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User userId;

    @NotBlank(message = "Username must not be empty")
    @Size(min = 1, max = 50, message = "wallet name must between the ranges of 1 and 50")
    private String name;
    private BigDecimal balance;

    public Wallet(User user, String name, BigDecimal balance) {
        setUser(user);
        setName(name);
        this.balance = balance;
    }

    public void setUser(User user) {
        if(user != null && user.getEmail() != null){
            user.setEmail(user.getEmail().toLowerCase().trim());
        }
        this.userId = user;
    }

    public void setName(String name) {
        if (name != null){
            this.name = name.trim().replace("\\c+", " ");
        }else {
            this.name = null;
        }
    }

}
