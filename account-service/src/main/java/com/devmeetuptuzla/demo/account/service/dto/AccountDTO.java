package com.devmeetuptuzla.demo.account.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDTO {

    private Long id;
    private String name;
    private Double balance;
    private String currency;
    List<TransactionDTO> transactions;
}
