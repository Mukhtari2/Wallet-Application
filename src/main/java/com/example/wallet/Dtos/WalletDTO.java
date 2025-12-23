package com.example.wallet.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletDTO {
    private Long id;
    private Long userId;

    @NotBlank(message = "Wallet name is required")
    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;

    private BigDecimal balance;


    public void setName(String name) {
        if(name != null){
            this.name = name.trim().replace("\\s+", " ");
        }else {
            this.name = null;
        }
    }

}
