create table locations
(
    id           bigint       not null primary key,
    address      varchar(255) not null,
    restaurantId bigint,
    CONSTRAINT FK_RESTAURANT_LOCATION FOREIGN KEY (restaurantId) REFERENCES restaurants (id)
);

alter table locations owner to root;

create sequence location_id_seq;

alter sequence location_id_seq owner to root;