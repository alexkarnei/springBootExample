create table using_history (
    id int8 not null,
    is_free boolean not null,
    notes varchar(255),
    car_id int8 not null ,
    owner_id int8 not null ,
    primary key (id)
);

 alter table if exists using_history add constraint car_history foreign key (car_id) references car;
alter table if exists using_history add constraint owner_history foreign key (owner_id) references owner;
