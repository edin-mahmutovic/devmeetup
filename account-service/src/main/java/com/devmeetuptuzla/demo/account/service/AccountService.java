package com.devmeetuptuzla.demo.account.service;

import com.devmeetuptuzla.demo.account.client.TransactionClient;
import com.devmeetuptuzla.demo.account.entity.Account;
import com.devmeetuptuzla.demo.account.repository.AccountRepository;
import com.devmeetuptuzla.demo.account.service.dto.AccountCreateDTO;
import com.devmeetuptuzla.demo.account.service.dto.AccountDTO;
import com.devmeetuptuzla.demo.account.service.dto.TransactionDTO;
import com.devmeetuptuzla.demo.account.service.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final TransactionClient transactionClient;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper,
                          TransactionClient transactionClient) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
        this.transactionClient = transactionClient;
    }

    public Account createAccount(AccountCreateDTO accountCreateDTO) {
        Account account = accountMapper.toEntity(accountCreateDTO);
        return accountRepository.save(account);
    }

    public List<Account> findAccounts(String customerId) {
        return accountRepository.findAccountByCustomerId(customerId);
    }

    public AccountDTO findAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account Not Found."));

        AccountDTO accountDTO = accountMapper.toDTO(account);
        List<TransactionDTO> transactions = transactionClient.findAccountTransactions(accountId);
        accountDTO.setTransactions(transactions);

        return accountDTO;
    }

    @Transactional
    public void updateAccountBalance(Long accountId, Double amount) {
        accountRepository.updateAccountBalance(accountId, amount);
    }
}
