# todolistapp
Small REST api todolist app implemented using Bootspring + MVC Spring + JPA + PostgreSQL

Database schema:

CREATE SEQUENCE todoitems_id_seq;
CREATE TABLE todoitems(
id BIGINT DEFAULT NEXTVAL('todoitems_id_seq'),
title VARCHAR(100),
description VARCHAR(255),
is_completed BOOLEAN
);
