package com.devmeetuptuzla.demo.customer.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {

    private String id;
    private String firstName;
    private String lastName;
    private List<Account> accounts;
}
