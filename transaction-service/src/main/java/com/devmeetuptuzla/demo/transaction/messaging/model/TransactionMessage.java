package com.devmeetuptuzla.demo.transaction.messaging.model;

import lombok.Data;

@Data
public class TransactionMessage {

    private Long accountId;
    private Double amount;
}
