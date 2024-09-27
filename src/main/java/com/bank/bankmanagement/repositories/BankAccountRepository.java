package com.bank.bankmanagement.repositories;

import com.bank.bankmanagement.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

    @Query("select bc from BankAccount bc where bc.customer = :customerId")
    List<BankAccount> customerbankAccounts(@Param("customerId") Long customerId);
}
