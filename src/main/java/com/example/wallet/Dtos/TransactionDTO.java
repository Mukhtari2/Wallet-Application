package com.example.wallet.Dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long walletId;
    @NotBlank(message = "Bill Category is required")
    @Size(min = 2, max = 50, message = "characters must be between 2 - 50 length")
    private String billCategory;
    private String type;
    private BigDecimal amount;
    private String description;
    @JsonFormat(pattern = "d/M/yyyy")
    private LocalDate date;

}
