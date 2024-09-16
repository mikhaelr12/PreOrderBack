create table items
(
    id           bigint       not null primary key,
    dish_name    varchar(255) not null unique,
    price        int          not null,
    description  varchar(255) not null,
    is_available BIT,
    image        bytea,
    menu_id      bigint,
    CONSTRAINT FK_MENU_ITEM FOREIGN KEY (menu_id) REFERENCES menus (id)
);

alter table items owner to root;

create sequence item_id_seq;

alter sequence item_id_seq owner to root;