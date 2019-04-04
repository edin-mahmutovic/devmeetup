package com.devmeetuptuzla.demo.customer.client;

import com.devmeetuptuzla.demo.customer.client.fallback.AccountClientFallback;
import com.devmeetuptuzla.demo.customer.service.dto.AccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Primary
@FeignClient(value = "account-service", fallback = AccountClientFallback.class)
public interface AccountClient {

    @GetMapping("/{customerId}")
    List<AccountDTO> findCustomerAccounts(@PathVariable("customerId") String customerId);
}