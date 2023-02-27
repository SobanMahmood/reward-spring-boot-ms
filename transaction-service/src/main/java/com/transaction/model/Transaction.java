package com.transaction.model;

import java.util.Date;

public class Transaction {
    private Integer transactionId;
    private Integer customerId;
    private Double amount;
    private Date date;

    public Transaction(Integer transactionId, Integer cId, Double amount, Date date) {
        this.transactionId = transactionId;
        this.customerId = cId;
        this.amount = amount;
        this.date = date;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Integer getTransactionId() {
        return transactionId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
