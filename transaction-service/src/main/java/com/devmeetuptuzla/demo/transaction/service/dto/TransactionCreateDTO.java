package com.devmeetuptuzla.demo.transaction.service.dto;

import com.devmeetuptuzla.demo.transaction.entity.enumeration.TransactionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TransactionCreateDTO {

    @NotNull
    private Long accountId;

    @NotNull
    private TransactionType type;

    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    private Date date;

    @NotNull
    private Double amount;

    private String description;
}
