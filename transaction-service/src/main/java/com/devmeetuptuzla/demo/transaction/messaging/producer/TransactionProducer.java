package com.devmeetuptuzla.demo.transaction.messaging.producer;

import com.devmeetuptuzla.demo.transaction.messaging.TransactionChannel;
import com.devmeetuptuzla.demo.transaction.messaging.model.TransactionMessage;
import com.devmeetuptuzla.demo.transaction.service.util.MessagingUtil;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    private final TransactionChannel transactionChannel;

    public TransactionProducer(TransactionChannel transactionChannel) {
        this.transactionChannel = transactionChannel;
    }

    public void produce(TransactionMessage message) {
        transactionChannel.channel().send(MessagingUtil.buildMessage(message));
    }
}
