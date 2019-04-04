package com.devmeetuptuzla.demo.transaction.controller;

import com.devmeetuptuzla.demo.transaction.entity.Transaction;
import com.devmeetuptuzla.demo.transaction.service.TransactionService;
import com.devmeetuptuzla.demo.transaction.service.dto.TransactionCreateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api("Operations about transaction.")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/")
    @ApiOperation("Add new transaction")
    public Transaction post(@RequestBody @Valid TransactionCreateDTO transactionCreateDTO) {
        return transactionService.createTransaction(transactionCreateDTO);
    }

    @GetMapping("/{accountId}")
    @ApiOperation(value = "Get transactions for account", response = Transaction.class, responseContainer = "List")
    public List<Transaction> get(@PathVariable("accountId") Long accountId) {
        return transactionService.findTransactions(accountId);
    }
}
