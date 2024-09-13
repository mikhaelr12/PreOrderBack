create table bookings
(
    id            bigint not null primary key,
    userId        bigint not null,
    tableId       bigint not null,
    locationId    bigint not null,
    bookingStatus varchar(255),
    orderTime     timestamp,
    numOfPeople   int,
    preferences   varchar(255),
    finalPrice    int,
    CONSTRAINT FK_USER_BOOKING FOREIGN KEY (userId) REFERENCES users (id),
    CONSTRAINT FK_RESTAURANTTABLE_BOOKING FOREIGN KEY (tableId) REFERENCES restauranttables (id),
    CONSTRAINT FK_LOCATION_BOOKING FOREIGN KEY (locationId) REFERENCES locations (id)
);

alter table bookings owner to root;

create sequence booking_id_seq;

alter sequence booking_id_seq owner to root;