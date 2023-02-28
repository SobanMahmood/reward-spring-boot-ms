package com.transaction.repository;

import com.transaction.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String SQL_GET_BY_ID = "SELECT CUSTOMER_ID, TRANSACTION_ID, AMOUNT, TRANSACTION_DATE FROM TRANSACTIONS WHERE CUSTOMER_ID = ?";
    private RowMapper<Transaction> rowMapper = new RowMapper<Transaction>() {
        @Override
        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Transaction(rs.getInt("TRANSACTION_ID"),
                    rs.getInt("CUSTOMER_ID"),
                    rs.getDouble("AMOUNT"),
                    rs.getTimestamp("TRANSACTION_DATE"));
        }
    };
    @Override
    public List<Transaction> getByCustomer(Integer customerId) {
        return jdbcTemplate.query(SQL_GET_BY_ID, new Object[]{customerId}, rowMapper);
    }
}
