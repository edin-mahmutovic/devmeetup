package com.devmeetuptuzla.demo.customer.client;

import com.devmeetuptuzla.demo.customer.service.dto.Account;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AccountClient {

    private final RestTemplate restTemplate;

    public AccountClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "findCustomerAccountsFallback")
    public List<Account> findCustomerAccounts(String customerId) {
        Account[] result = restTemplate.getForObject(
                "http://account-service/{customerId}",
                Account[].class,
                customerId);

        return Arrays.asList(result);
    }

    public List<Account> findCustomerAccountsFallback(String customerId) {
        return new ArrayList<>();
    }
}
