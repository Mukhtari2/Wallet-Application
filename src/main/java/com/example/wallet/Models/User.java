package com.example.wallet.Models;

import com.example.wallet.Enum.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @SequenceGenerator(
            name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1
    )

    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 50, message = "Name must be between the range of 1 to 50 characters")
    private String name;

    @NotNull(message = "Email must be provided")
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email, must be in lower case")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Password must be provided")
    @NotBlank(message = "password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String phoneNumber;

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
