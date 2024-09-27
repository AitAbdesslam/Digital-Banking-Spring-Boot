package com.bank.bankmanagement.services;

import com.bank.bankmanagement.dtos.CustomerDTO;
import com.bank.bankmanagement.entities.Customer;
import com.bank.bankmanagement.exceptions.CustomerNotFoundException;
import lombok.NoArgsConstructor;

import java.util.List;

public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> listCustomers();

    List<CustomerDTO> searchCustomers(String keyword);

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);
}
