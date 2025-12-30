package com.example.wallet.Dtos;

import com.example.wallet.Enum.Status;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    private String name;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;


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
