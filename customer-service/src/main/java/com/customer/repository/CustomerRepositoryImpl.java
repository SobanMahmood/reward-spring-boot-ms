package com.customer.repository;

import com.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_GET_All = "SELECT CUSTOMER_ID, FIRST_NAME, LAST_NAME FROM CUSTOMERS";
    private RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Customer(rs.getInt("CUSTOMER_ID"),
                    rs.getString("FIRST_NAME"),
                    rs.getString("LAST_NAME"));
        }
    };
    @Override
    public List<Customer> fetchAllCustomers() {
        return jdbcTemplate.query(SQL_GET_All, rowMapper);
    }
}
