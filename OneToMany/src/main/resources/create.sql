create table AUTHOR (id integer not null, name varchar(255), COUNTRY_ID integer, primary key (id));
create table COUNTRY (id integer not null, name varchar(255), primary key (id));
create table POST (id integer not null, name varchar(255), AUTHOR_ID integer, primary key (id));
alter table AUTHOR add constraint FKhav5e7wkcm2dgwves8e6lwahi foreign key (COUNTRY_ID) references COUNTRY;
alter table POST add constraint FK4mb5i28v16s80ccdov4n6fgb6 foreign key (AUTHOR_ID) references AUTHOR;
