package com.bank.bankmanagement.entities;

import com.bank.bankmanagement.enums.OperationType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_operation")
public class AccountOperation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private BankAccount bankAccount;
    private double amount;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    private String description;
}