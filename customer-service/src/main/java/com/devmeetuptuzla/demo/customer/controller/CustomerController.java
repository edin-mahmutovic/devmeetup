package com.devmeetuptuzla.demo.customer.controller;

import com.devmeetuptuzla.demo.customer.entity.Customer;
import com.devmeetuptuzla.demo.customer.service.CustomerService;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerCreateDTO;
import com.devmeetuptuzla.demo.customer.service.dto.CustomerDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api("Operations about customers.")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Add new customer", response = Customer.class)
    public Customer post(@RequestBody @Valid CustomerCreateDTO customerCreateDTO) {
        return customerService.createCustomer(customerCreateDTO);
    }

    @GetMapping("/")
    @ApiOperation(value = "Get customers", response = Customer.class, responseContainer = "List")
    public List<Customer> get() {
        return customerService.findCustomers();
    }

    @GetMapping("/{customerId}")
    @ApiOperation(value = "Get customer with accounts", response = CustomerDTO.class)
    public CustomerDTO get(@PathVariable("customerId") String customerId) {
        return customerService.findCustomer(customerId);
    }
}
