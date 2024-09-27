package com.bank.bankmanagement.services;

import com.bank.bankmanagement.exceptions.BalanceNotSufficientException;
import com.bank.bankmanagement.exceptions.BankAccountNotFoundException;

public interface AccountOperationService {
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

}
