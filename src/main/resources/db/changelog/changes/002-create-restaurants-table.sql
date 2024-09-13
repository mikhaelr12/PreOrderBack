create table restaurants
(
    id             bigint       not null primary key,
    restaurantName varchar(255) not null,
    logo           bytea,
    categoryId     bigint,
    CONSTRAINT FK_CATEGORY_RESTAURANT FOREIGN KEY (categoryId) REFERENCES categories (id)
);

alter table restaurants owner to root;

create sequence restaurant_id_seq;

alter sequence restaurant_id_seq owner to root;