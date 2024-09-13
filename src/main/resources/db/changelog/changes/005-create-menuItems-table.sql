create table menuItems(
                      id bigint not null primary key,
                      dishName varchar(255) not null unique ,
                      price int not null,
                      description varchar(255) not null,
                      isAvailable BIT,
                      image bytea,
                      menuId bigint,
                      CONSTRAINT FK_MENU_ITEM FOREIGN KEY (menuId) REFERENCES menus(id)
);

alter table menuItems owner to root;

create sequence menuItem_id_seq;

alter sequence menuItem_id_seq owner to root;