package com.example.wallet.Models;

import com.example.wallet.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "user_token")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_token_sequence")
    private Long id;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String token;
}
