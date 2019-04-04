package com.devmeetuptuzla.demo.customer.service.dto;

import lombok.Data;

@Data
public class AccountDTO {

    private Long id;
    private String name;
    private Double balance;
    private String currency;
}