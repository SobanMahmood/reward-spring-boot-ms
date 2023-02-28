package com.customer.repository;

import com.customer.model.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> fetchAllCustomers();
}
