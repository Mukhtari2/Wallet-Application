package com.example.wallet.Models;

import com.example.wallet.Enum.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;
    private String name;

    @NotNull(message = "Email must be provided")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email, must be in lower case")
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Status status;


    public void setEmail(String email) {
        if(email != null) {
            this.email = email.toLowerCase();
        }else {
            this.email = null;
        }
    }

}
