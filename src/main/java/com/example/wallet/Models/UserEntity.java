package com.example.wallet.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_entity_sequence")
    private Long id;
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email, must be in lower case")
    @Column(unique = true)
    private String email;

    public UserEntity() {
    }

    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserEntity(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
            this.name = name;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null) {
            this.email = email.toLowerCase().trim();
        }else {
            this.email = null;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
