insert into users (id, active, password, username, is_deleted)
values (1, true, '123', 'admin', false);

insert into user_role (user_id, roles)
values (1, 'ADMIN');