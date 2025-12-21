package com.example.wallet.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    private Long id;
    @NotBlank(message = "User name is required")
    @Size(min = 1, max = 5, message = "Name must be between the range of 1 to 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email, must be in lower case")
    private String email;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        if (name != null) {
            this.name = name.trim().replace("\\c+", " ");
        }else {
            this.name = null;


        }
    }
    public String getName() {
        return name;
    }
    public void setEmail(String email) {
        if(email != null) {
            this.email = email.toLowerCase().trim();
        }else {
            this.email = null;
        }
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
