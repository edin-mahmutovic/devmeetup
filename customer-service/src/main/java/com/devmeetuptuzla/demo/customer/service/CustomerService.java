package com.devmeetuptuzla.demo.customer.service;

import com.devmeetuptuzla.demo.customer.client.AccountClient;
import com.devmeetuptuzla.demo.customer.entity.Customer;
import com.devmeetuptuzla.demo.customer.repository.CustomerRepository;
import com.devmeetuptuzla.demo.customer.service.dto.Account;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerCreateDTO;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerDTO;
import com.devmeetuptuzla.demo.customer.service.mapper.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AccountClient accountClient;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper,
                           AccountClient accountClient) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.accountClient = accountClient;
    }

    public void createCustomer(CustomerCreateDTO customerCreateDTO) {
        Customer customer = customerMapper.toEntity(customerCreateDTO);
        customerRepository.save(customer);
    }

    public CustomerDTO findCustomer(String customerId) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));

        CustomerDTO customerDTO = customerMapper.toDTO(customer);

        log.info("Fetch accounts from customer service");
        List<Account> accounts = accountClient.findCustomerAccounts(customerId);
        customerDTO.setAccounts(accounts);

        return customerDTO;
    }

    public List<Customer> findCustomers() {
        return customerRepository.findAll();
    }
}
