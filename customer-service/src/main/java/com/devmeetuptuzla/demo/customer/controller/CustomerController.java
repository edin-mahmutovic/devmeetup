package com.devmeetuptuzla.demo.customer.controller;

import com.devmeetuptuzla.demo.customer.entity.Customer;
import com.devmeetuptuzla.demo.customer.service.CustomerService;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerCreateDTO;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void createCustomer(@RequestBody @Valid CustomerCreateDTO customerCreateDTO) {
        customerService.createCustomer(customerCreateDTO);
    }

    @GetMapping
    public List<Customer> findCustomers() {
        return customerService.findCustomers();
    }

    @GetMapping("/{customerId}")
    public CustomerDTO findCustomer(@PathVariable("customerId") String customerId) {
        return customerService.findCustomer(customerId);
    }
}
