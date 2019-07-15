# todolistapp
Small REST api todolist app implemented using Bootspring + MVC Spring + JPA + PostgreSQL

Database schema:

CREATE SEQUENCE todoitems_id_seq;<br />
CREATE TABLE todoitems( <br />
id BIGINT DEFAULT NEXTVAL('todoitems_id_seq'), <br />
title VARCHAR(100), <br />
description VARCHAR(255), <br />
is_completed BOOLEAN); 
