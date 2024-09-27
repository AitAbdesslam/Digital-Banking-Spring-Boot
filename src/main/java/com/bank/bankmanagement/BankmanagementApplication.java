package com.bank.bankmanagement;

import com.bank.bankmanagement.dtos.BankAccountDTO;
import com.bank.bankmanagement.dtos.CurrentBankAccountDTO;
import com.bank.bankmanagement.dtos.CustomerDTO;
import com.bank.bankmanagement.dtos.SavingBankAccountDTO;
import com.bank.bankmanagement.exceptions.CustomerNotFoundException;
import com.bank.bankmanagement.services.AccountOperationService;
import com.bank.bankmanagement.services.BankAccountService;
import com.bank.bankmanagement.services.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class BankmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankmanagementApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService, BankAccountService bankAccountService, AccountOperationService accountOperationService){
        return args -> {
            Stream.of("Hassan","Imane","Mohamed").forEach(name->{
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerService.saveCustomer(customer);
            });
            customerService.listCustomers().forEach(customer->{
                try {
                    bankAccountService.saveCurrentBankAccount(Math.random()*90000,9000,customer.getId());
                    bankAccountService.saveSavingBankAccount(Math.random()*120000,5.5,customer.getId());

                } catch (CustomerNotFoundException e) {
                    e.printStackTrace();
                }
            });
            List<BankAccountDTO> bankAccounts = bankAccountService.listBankAccounts();
            for (BankAccountDTO bankAccount:bankAccounts){
                for (int i = 0; i <10 ; i++) {
                    String accountId;
                    if(bankAccount instanceof SavingBankAccountDTO){
                        accountId=((SavingBankAccountDTO) bankAccount).getId();
                    } else{
                        accountId=((CurrentBankAccountDTO) bankAccount).getId();
                    }
                    accountOperationService.credit(accountId,10000+Math.random()*120000,"Credit");
                    accountOperationService.debit(accountId,1000+Math.random()*9000,"Debit");
                }
            }
        };
    }



}
