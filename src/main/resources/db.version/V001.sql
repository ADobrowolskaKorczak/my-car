--liquibase formatted sql
--changeset adobrowolskakorczak:1

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);