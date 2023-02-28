# Customer Transactions Reward App

## Reward Service
This project is responsible for fetching needed data and calculating rewards.

Reward service is communicating with transactions service to get required transactions and then calculate reward for a customer. 
Currently we are using following end-points as per requirement.
[localhost:9001/api/v1/reward/customer/{customerId}](localhost:9003/api/v1/reward/customer/{customerId})
<br/>This retrieves total and per month rewards for a customer.