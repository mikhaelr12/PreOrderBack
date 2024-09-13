create table menus(
                            id bigint not null primary key,
                            locationId bigint,
                            CONSTRAINT FK_LOCATION_MENU FOREIGN KEY (locationId) REFERENCES locations(id)
);

alter table menus owner to root;

create sequence menu_id_seq;

alter sequence menu_id_seq owner to root;