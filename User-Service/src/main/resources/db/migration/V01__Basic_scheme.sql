create schema if not exists fintrack;

create table if not exists fintrack.users
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    username varchar(50) unique,
    email varchar(100)
);