package com.devmeetuptuzla.demo.account.messaging.consumer;

import com.devmeetuptuzla.demo.account.messaging.TransactionChannel;
import com.devmeetuptuzla.demo.account.messaging.model.TransactionMessage;
import com.devmeetuptuzla.demo.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TransactionConsumer {

    private final AccountService accountService;

    public TransactionConsumer(AccountService accountService) {
        this.accountService = accountService;
    }

    @StreamListener(target = TransactionChannel.CHANNEL_NAME)
    public void consume(TransactionMessage message) {
        log.info("Received message: " + message);
        accountService.updateAccountBalance(message.getAccountId(), message.getAmount());
    }
}
