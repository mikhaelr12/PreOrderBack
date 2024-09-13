create table users
(
    id       bigint       not null primary key,
    username varchar(255) not null unique,
    password varchar(255) not null,
    email    varchar(255) not null unique,
    phone    varchar(255) not null
);

alter table users owner to root;

create sequence user_id_seq;

alter sequence user_id_seq owner to root;