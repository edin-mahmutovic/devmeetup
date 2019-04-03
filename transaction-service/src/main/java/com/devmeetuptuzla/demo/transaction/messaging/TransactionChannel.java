package com.devmeetuptuzla.demo.transaction.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransactionChannel {

    String TRANSACTION_CHANNEL = "transaction-channel";

    @Output(TRANSACTION_CHANNEL)
    MessageChannel channel();
}
