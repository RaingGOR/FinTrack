create schema if not exists user_service;

create table if not exists user_service.users
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    username varchar(50) unique,
    email    varchar(100) unique,
    password varchar(100)
);