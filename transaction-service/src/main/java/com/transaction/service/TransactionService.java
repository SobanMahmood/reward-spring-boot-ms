package com.transaction.service;

import com.transaction.model.Transaction;

import java.util.List;

public interface TransactionService {

    public List<Transaction> fetchTransactions(Integer customerId);
}
