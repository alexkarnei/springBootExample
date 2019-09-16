create table owner
(
    id int8    not null,
    createddate  timestamp,
    is_deleted   boolean not null,
    updated_date timestamp,
    firstName    varchar(255),
    primary key (id)
);