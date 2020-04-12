drop table if exists ACCOUNT;

create table ACCOUNT (
  ID int primary key not null,
  USERNAME varchar(100) not null,
  EMAIL varchar(100) not null
);
