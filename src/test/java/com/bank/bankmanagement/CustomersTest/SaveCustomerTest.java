package com.bank.bankmanagement.CustomersTest;

import com.bank.bankmanagement.dtos.CustomerDTO;
import com.bank.bankmanagement.exceptions.CustomerNotFoundException;
import com.bank.bankmanagement.mappers.CustomerMapperImpl;
import com.bank.bankmanagement.repositories.CustomerRepository;
import com.bank.bankmanagement.services.CustomerService;
import com.bank.bankmanagement.services.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;



public class SaveCustomerTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapperImpl customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        // Initialisation des mocks
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save()
    {
        String name="med";
        CustomerDTO customer = new CustomerDTO();
        customer.setName(name);
        customer.setEmail(name+"@gmail.com");
        CustomerDTO scustomer = customerService.saveCustomer(customer);
        assertNotNull(scustomer);
    }

    @Test
    public void testSaveCustomerSuccess() throws CustomerNotFoundException {
        CustomerDTO customerDTO = new CustomerDTO().builder().id(804433L).name("mohamed").email("mohamed_jhd@gmail.com").build();
        //customerDTO.setId(80L);
        //customerDTO.setName("mohamed");
        //customerDTO.setEmail("mohamed_jhd@gmail.com");
        //CustomerDTO saveCustomerDTO = customerService.saveCustomer(customerDTO);
        //CustomerDTO customerDTO = customerService.getCustomer(150L);
        //assertEquals(1, customerService.getCustomers().size());
        //assertEquals(customerDTO, saveCustomerDTO);
    }




}
