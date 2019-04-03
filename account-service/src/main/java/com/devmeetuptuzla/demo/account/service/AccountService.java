package com.devmeetuptuzla.demo.account.service;

import com.devmeetuptuzla.demo.account.service.dto.AccountCreateDTO;
import com.devmeetuptuzla.demo.account.entity.Account;
import com.devmeetuptuzla.demo.account.repository.AccountRepository;
import com.devmeetuptuzla.demo.account.service.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public List<Account> findAccounts(String customerId) {
        log.info("Fetch accounts for customer " + customerId);
        return accountRepository.findAccountByCustomerId(customerId);
    }

    public void createAccount(AccountCreateDTO accountCreateDTO) {
        Account account = accountMapper.toEntity(accountCreateDTO);
        accountRepository.save(account);
    }

    @Transactional
    public void updateAccountBalance(Long accountId, Double amount) {
        accountRepository.updateAccountBalance(accountId, amount);
    }
}
