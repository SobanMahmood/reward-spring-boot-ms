package com.transaction.service;

import com.transaction.model.Transaction;
import com.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> fetchTransactions(Integer customerId) {
        return transactionRepository.getByCustomer(customerId);
    }
}
