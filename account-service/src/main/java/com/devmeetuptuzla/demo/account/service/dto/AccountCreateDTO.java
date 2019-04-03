package com.devmeetuptuzla.demo.account.service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AccountCreateDTO {

    @NotNull
    private String name;
    @NotNull
    private Double balance;
    @NotNull
    private String currency;
    @NotNull
    private String customerId;
}
