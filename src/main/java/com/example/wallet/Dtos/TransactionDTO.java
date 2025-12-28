package com.example.wallet.Dtos;


import com.example.wallet.Enum.BillCategory;
import com.example.wallet.Enum.BillType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private BillCategory billCategory;

    @Enumerated(EnumType.STRING)
    private BillType type;

    private BigDecimal amount;
    private String description;
    @JsonFormat(pattern = "d/M/yyyy")
    private LocalDate date;

}
