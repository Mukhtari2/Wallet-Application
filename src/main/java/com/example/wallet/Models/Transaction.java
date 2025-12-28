package com.example.wallet.Models;

import com.example.wallet.Enum.BillType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    private String billCategory;

    @Enumerated(EnumType.STRING)
    private BillType type;

    private BigDecimal amount;
    private String description;
    private LocalDate date;
}
