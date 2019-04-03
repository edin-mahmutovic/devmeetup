package com.devmeetuptuzla.demo.transaction.service;

import com.devmeetuptuzla.demo.transaction.entity.Transaction;
import com.devmeetuptuzla.demo.transaction.messaging.model.TransactionMessage;
import com.devmeetuptuzla.demo.transaction.messaging.producer.TransactionProducer;
import com.devmeetuptuzla.demo.transaction.repository.TransactionRepository;
import com.devmeetuptuzla.demo.transaction.service.dto.TransactionCreateDTO;
import com.devmeetuptuzla.demo.transaction.service.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final TransactionProducer transactionProducer;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper,
                              TransactionProducer transactionProducer) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.transactionProducer = transactionProducer;
    }

    public void createTransaction(TransactionCreateDTO transactionCreateDTO) {
        Transaction transaction = transactionMapper.toEntity(transactionCreateDTO);
        transactionRepository.save(transaction);

        TransactionMessage message = transactionMapper.toMessage(transaction);
        transactionProducer.produce(message);
    }
}
