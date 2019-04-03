package com.devmeetuptuzla.demo.account.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TransactionChannel {

    String CHANNEL_NAME = "transaction-channel";

    @Input(CHANNEL_NAME)
    SubscribableChannel channel();
}
