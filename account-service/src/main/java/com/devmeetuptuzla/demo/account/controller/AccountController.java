package com.devmeetuptuzla.demo.account.controller;

import com.devmeetuptuzla.demo.account.entity.Account;
import com.devmeetuptuzla.demo.account.service.AccountService;
import com.devmeetuptuzla.demo.account.service.dto.AccountCreateDTO;
import com.devmeetuptuzla.demo.account.service.dto.AccountDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api("Operations about accounts.")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/")
    @ApiOperation(value = "Add new account", response = Account.class)
    public Account post(@RequestBody @Valid AccountCreateDTO accountCreateDTO) {
        return accountService.createAccount(accountCreateDTO);
    }

    @GetMapping("/{customerId}")
    @ApiOperation(value = "Get accounts for customer.", response =  Account.class, responseContainer = "List")
    public List<Account> get(@PathVariable("customerId") String customerId) {
        return accountService.findAccounts(customerId);
    }

    @GetMapping("/{accountId}/transactions")
    @ApiOperation(value = "Get account with transactions", response = AccountDTO.class)
    public AccountDTO get(@PathVariable("accountId") Long accountId) {
        return accountService.findAccount(accountId);
    }
}
