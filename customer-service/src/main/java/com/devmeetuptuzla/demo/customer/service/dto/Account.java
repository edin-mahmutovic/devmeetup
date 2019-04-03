package com.devmeetuptuzla.demo.customer.service.dto;

import lombok.Data;

@Data
public class Account {

    private Long id;
    private String name;
    private Double balance;
    private String currency;
    private String customerId;
}