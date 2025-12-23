package com.example.wallet.Dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between the range of 1 to 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email, must be in lower case")
    private String email;


    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name.trim();
        }else {
            this.name = null;
        }
    }

    public void setEmail(String email) {
        if(email != null) {
            this.email = email.toLowerCase().trim();
        }else {
            this.email = null;
        }
    }

}
