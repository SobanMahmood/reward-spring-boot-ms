package com.transaction.repository;

import com.transaction.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> getByCustomer(Integer customerId);
}
