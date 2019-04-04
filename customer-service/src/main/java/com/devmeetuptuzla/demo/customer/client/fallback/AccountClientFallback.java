package com.devmeetuptuzla.demo.customer.client.fallback;

import com.devmeetuptuzla.demo.customer.client.AccountClient;
import com.devmeetuptuzla.demo.customer.service.dto.AccountDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountClientFallback implements AccountClient {

    @Override
    public List<AccountDTO> findCustomerAccounts(String customerId) {
        return new ArrayList<>();
    }
}