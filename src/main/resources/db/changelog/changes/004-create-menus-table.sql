create table menus
(
    id          bigint not null primary key,
    location_id bigint not null,
    CONSTRAINT FK_LOCATION_MENU FOREIGN KEY (location_id) REFERENCES locations (id)
);

alter table menus owner to root;

create sequence menu_id_seq;

alter sequence menu_id_seq owner to root;