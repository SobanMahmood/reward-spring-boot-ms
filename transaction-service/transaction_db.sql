drop database transactiondb;
drop user transaction;

create user transaction with password 'password';
create database transactiondb with template=template0 owner=transaction;
\connect transactiondb;
alter default privileges grant all on tables to transaction;
alter default privileges grant all on sequences to transaction;

create table transactions(
transaction_id bigserial primary key not null,
customer_id integer not null,
amount numeric(10,2) not null,
transaction_date timestamp not null
);

insert into transactions (customer_id, amount, transaction_date) values (1, 100, date '2022-12-19');
insert into transactions (customer_id, amount, transaction_date) values (1, 50, date '2022-12-29');
insert into transactions (customer_id, amount, transaction_date) values (1, 40, date '2023-01-09');
insert into transactions (customer_id, amount, transaction_date) values (1, 70, date '2023-01-19');
insert into transactions (customer_id, amount, transaction_date) values (1, 80, date '2023-02-09');
insert into transactions (customer_id, amount, transaction_date) values (1, 200, date '2023-02-19');
insert into transactions (customer_id, amount, transaction_date) values (2, 10, date '2022-12-10');
insert into transactions (customer_id, amount, transaction_date) values (2, 100, date '2022-12-11');
insert into transactions (customer_id, amount, transaction_date) values (2, 70, date '2023-01-09');
insert into transactions (customer_id, amount, transaction_date) values (2, 130, date '2023-02-09');
insert into transactions (customer_id, amount, transaction_date) values (3, 20, date '2023-01-09');
insert into transactions (customer_id, amount, transaction_date) values (3, 110, date '2023-01-09');
