create database if not exists transactional_service;

create table if not exists transactions
(
    id           BIGINT PRIMARY KEY AUTO_INCREMENT,
    sender_id    BIGINT    NOT NULL,
    recipient_id BIGINT    NOT NULL,
    date         TIMESTAMP NOT NULL,
    amount       DOUBLE    NOT NULL,
    description  VARCHAR(255),
    type         VARCHAR(50),
    status       VARCHAR(50)
);
