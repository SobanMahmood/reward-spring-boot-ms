package com.transaction.controller;

import com.transaction.model.Transaction;
import com.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping("/customer/{customerId}")
    public List<Transaction> getTransaction(@PathVariable("customerId") Integer customerId) {
        // TODO: replace with original data
        return transactionService.fetchTransactions(customerId);
    }
}
