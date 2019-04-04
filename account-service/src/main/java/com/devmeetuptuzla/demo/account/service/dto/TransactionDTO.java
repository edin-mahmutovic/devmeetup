package com.devmeetuptuzla.demo.account.service.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO {

    private Long id;
    private String type;
    private Date date;
    private Double amount;
    private String description;
}
