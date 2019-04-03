package com.devmeetuptuzla.demo.transaction.service.mapper;

import com.devmeetuptuzla.demo.transaction.entity.Transaction;
import com.devmeetuptuzla.demo.transaction.entity.enumeration.TransactionType;
import com.devmeetuptuzla.demo.transaction.messaging.model.TransactionMessage;
import com.devmeetuptuzla.demo.transaction.service.dto.TransactionCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionMapper {

    @Mapping(target = "id", ignore = true)
    Transaction toEntity(TransactionCreateDTO transactionCreateDTO);

    default TransactionMessage toMessage(Transaction transaction) {
        TransactionMessage message = new TransactionMessage();
        message.setAccountId(transaction.getAccountId());
        message.setAmount(transaction.getType().equals(TransactionType.DEPOSIT) ?
                transaction.getAmount() : -1 * transaction.getAmount());

        return message;
    }
}
