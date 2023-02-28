# Customer Transactions and Reward App

## Transaction Service
This project is responsible for handling transaction data. It has its own database, and its script is placed in the root directory which can be run to setup and populate database with dummy data.

Currently we are using following end-points as per requirement.
[localhost:9002/api/v1/transactions/customer/{customerId}](localhost:9003/api/v1/transactions/customer/{customerId})
<br/>This retrieves all transactions of a customer.