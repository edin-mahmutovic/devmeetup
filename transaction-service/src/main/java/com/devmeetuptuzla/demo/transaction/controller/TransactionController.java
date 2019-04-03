package com.devmeetuptuzla.demo.transaction.controller;

import com.devmeetuptuzla.demo.transaction.service.TransactionService;
import com.devmeetuptuzla.demo.transaction.service.dto.TransactionCreateDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void createTransaction(@RequestBody @Valid TransactionCreateDTO transactionCreateDTO) {
        transactionService.createTransaction(transactionCreateDTO);
    }
}
