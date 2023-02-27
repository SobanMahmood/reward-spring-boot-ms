package com.transaction.model;

import java.util.Date;

public class Transaction {
    private String customerId;
    private Long amount;
    private Date date;

    public Transaction(String cId, Long amount, Date date) {
        this.customerId = cId;
        this.amount = amount;
        this.date = date;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Long getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
