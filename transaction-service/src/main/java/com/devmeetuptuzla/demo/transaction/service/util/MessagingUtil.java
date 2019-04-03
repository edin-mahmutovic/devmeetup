package com.devmeetuptuzla.demo.transaction.service.util;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class MessagingUtil {

    private MessagingUtil() {

    }

    public static <T> Message<T> buildMessage(T model) {
        //String type = model.getClass().getSimpleName();
        return MessageBuilder.withPayload(model)
                //.setHeaderIfAbsent("type", type)
                .build();
    }
}
