package com.devmeetuptuzla.demo.account.controller;

import com.devmeetuptuzla.demo.account.service.dto.AccountCreateDTO;
import com.devmeetuptuzla.demo.account.entity.Account;
import com.devmeetuptuzla.demo.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public void createAccount(@RequestBody @Valid AccountCreateDTO accountCreateDTO) {
        accountService.createAccount(accountCreateDTO);
    }

    @GetMapping("/{customerId}")
    public List<Account> findAccounts(@PathVariable("customerId") String customerId) {
        return accountService.findAccounts(customerId);
    }
}
