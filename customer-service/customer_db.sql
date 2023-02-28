drop database customerdb;
drop user customer;

create user customer with password 'password';
create database customerdb with template=template0 owner=customer;
\connect customerdb;
alter default privileges grant all on tables to customer;
alter default privileges grant all on sequences to customer;

create table customers(
customer_id bigserial primary key not null,
first_name text not null,
last_name text
);

insert into customers (first_name, last_name) values ('Ali', 'Akram');
insert into customers (first_name, last_name) values ('Usman', 'Akram');
insert into customers (first_name, last_name) values ('Umer', 'Akram');
