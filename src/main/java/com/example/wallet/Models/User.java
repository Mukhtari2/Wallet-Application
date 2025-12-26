package com.example.wallet.Models;

import com.example.wallet.Enum.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between the range of 1 to 50 characters")
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
