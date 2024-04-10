create table Todo (
    id int not null, 
    user_id int not null,
    title varchar(150),
    completed boolean,
    version int
);