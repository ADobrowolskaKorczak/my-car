--liquibase formatted sql
--changeset adobrowolskakorczak:2

CREATE TABLE role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
);

CREATE TABLE user_role (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_id INT NOT NULL,
    user_id INT NOT NULL
);

ALTER TABLE user_role
    ADD CONSTRAINT user_role_role_id_fk
    FOREIGN KEY (role_id) REFERENCES role(id);

ALTER TABLE user_role
    ADD CONSTRAINT user_role_user_id_fk
    FOREIGN KEY (user_id) REFERENCES user(id);