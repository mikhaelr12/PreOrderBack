create table restaurantTables
(
    id         bigint not null primary key,
    locationId bigint,
    CONSTRAINT FK_LOCATION_RESTAURANTTABLE FOREIGN KEY (locationId) REFERENCES locations (id)
);

alter table restaurantTables owner to root;

create sequence restaurantTable_id_seq;

alter sequence restaurantTable_id_seq owner to root;