--liquibase formatted sql
--changeset adobrowolskakorczak:4

INSERT INTO user (id, first_name, last_name, email, password)
VALUES (1, 'Admin', 'Admin', 'admin@mycar.com', '$2a$12$I/UQ0Q9Rfx/CM2v.DtAU4.1ubRp1PgNUYHIodiIldKvRFYYqGvJIm');

INSERT INTO user_role (id, role_id, user_id) VALUES (1, 1, 1);