package com.bank.bankmanagement.services;
import com.bank.bankmanagement.dtos.*;
import com.bank.bankmanagement.exceptions.BankAccountNotFoundException;
import com.bank.bankmanagement.exceptions.CustomerNotFoundException;
import java.util.List;

public interface BankAccountService {
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;

    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<BankAccountDTO> listBankAccounts();

    BankAccountDTO getBankAccount(String bankAccountId) throws BankAccountNotFoundException;

    //BankAccountDTO updateBankAccount(BankAccountDTO bankAccountDTO);

    void deleteBankAccount(String bankAccountId);

    List<AccountOperationDTO> accountHistory(String accountId);

    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;


    List<BankAccountDTO> CustomerbankAccountsList(Long customerId) throws CustomerNotFoundException;
}
