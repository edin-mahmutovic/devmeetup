package com.devmeetuptuzla.demo.transaction.service;

import com.devmeetuptuzla.demo.transaction.entity.Transaction;
import com.devmeetuptuzla.demo.transaction.messaging.model.TransactionMessage;
import com.devmeetuptuzla.demo.transaction.messaging.producer.TransactionProducer;
import com.devmeetuptuzla.demo.transaction.repository.TransactionRepository;
import com.devmeetuptuzla.demo.transaction.service.dto.TransactionCreateDTO;
import com.devmeetuptuzla.demo.transaction.service.mapper.TransactionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Transaction createTransaction(TransactionCreateDTO transactionCreateDTO) {
        Transaction transaction = transactionMapper.toEntity(transactionCreateDTO);
        transaction = transactionRepository.save(transaction);

        TransactionMessage message = transactionMapper.toMessage(transaction);
        transactionProducer.produce(message);

        return transaction;
    }

    public List<Transaction> findTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
}
