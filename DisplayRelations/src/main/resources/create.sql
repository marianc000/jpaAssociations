create table AUTHOR (id integer not null, name varchar(255), country_id integer, primary key (id))
create table COUNTRY (id integer not null, name varchar(255), primary key (id))
create table POST (id integer not null, name varchar(255), author_id integer, primary key (id))
alter table AUTHOR add constraint FKc foreign key (country_id) references COUNTRY
alter table POST add constraint FKa foreign key (author_id) references AUTHOR
