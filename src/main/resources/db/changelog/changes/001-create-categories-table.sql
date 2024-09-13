create table categories
(
    id           bigint       not null primary key,
    categoryName varchar(255) not null
);

alter table categories owner to root;

create sequence category_id_seq;

alter sequence category_id_seq owner to root;