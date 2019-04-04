package com.devmeetuptuzla.demo.account.client;

import com.devmeetuptuzla.demo.account.service.dto.TransactionDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TransactionClient {

    private final RestTemplate restTemplate;

    public TransactionClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "findAccountTransactionsFallback")
    public List<TransactionDTO> findAccountTransactions(Long accountId) {
        TransactionDTO[] result = restTemplate.getForObject(
                "http://transaction-service/{accountId}",
                TransactionDTO[].class,
                accountId);

        return Arrays.asList(result);
    }

    public List<TransactionDTO> findAccountTransactionsFallback(Long accountId) {
        return new ArrayList<>();
    }
}
