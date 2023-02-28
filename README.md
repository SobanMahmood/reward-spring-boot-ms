# Customer Transactions and Reward App

The app is created using Spring Boot, ReactJS and Postgres. Basic microservices architecture is used.

### Backend
The backend consist of services divided into 3 groups. Customer, Transaction and Reward services.

To run the project, the 3 backend springboot projects needs to be run independently, these micro-services are communicating with each other.
1. [Customer Service](https://github.com/SobanMahmood/reward-spring-boot-ms/tree/main/customer-service)
2. [Transaction Service](https://github.com/SobanMahmood/reward-spring-boot-ms/tree/main/transaction-service)
3. [Reward Service](https://github.com/SobanMahmood/reward-spring-boot-ms/tree/main/reward_service)

### Database
Postgres DB script files are put in the project directory for Customer and Transaction databases. Each database is separate entity belonging to its own backend project.

### Frontend
[Frontend](https://github.com/SobanMahmood/reward-spring-boot-ms/tree/main/reward-web) can be run once backend is live.