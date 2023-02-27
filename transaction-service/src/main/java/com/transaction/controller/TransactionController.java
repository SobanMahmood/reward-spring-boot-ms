package com.transaction.controller;

import com.transaction.model.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @RequestMapping("/{customerId}")
    public Transaction getTransaction(@PathVariable("customerId") String customerId) {
        // TODO: replace with original data
        try {
            return new Transaction(customerId, 100L, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2023-02-01 10:10:10"));
        }
        catch (Exception e){

        };
        return null;
    }
}
