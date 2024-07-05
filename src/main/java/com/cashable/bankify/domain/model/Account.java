package com.cashable.bankify.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity(name = "accounts")
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    private String agency;

    @Column(nullable = false, precision = 13, scale = 2)
    private BigDecimal balance;


    @Column(name = "additional_limit", nullable = false, precision = 13, scale = 2)
    private BigDecimal limit;
}
