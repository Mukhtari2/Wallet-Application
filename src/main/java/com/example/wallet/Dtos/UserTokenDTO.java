package com.example.wallet.Dtos;

import com.example.wallet.Enum.Status;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenDTO {
    private Long id;
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String token;
}
