package com.example.wallet.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    private Long id;
    @NotBlank(message = "name is required")
    @Size(min = 1, max = 5, message = "Name must be between the range of 1 to 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email, must be in lower case")
    private String email;

    private String verificationToken;
    private boolean isVerified;

    @Column(name = "reset_token")
    private String resetToken;



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
        if (name != null && !name.isBlank()) {
            this.name = name.trim();
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

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", verificationToken='" + verificationToken + '\'' +
                ", isVerified=" + isVerified +
                ", resetToken='" + resetToken + '\'' +
                '}';
    }
}
