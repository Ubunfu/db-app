drop table if exists ACCOUNT;

create table ACCOUNT (
  ID int primary key AUTO_INCREMENT not null,
  USERNAME varchar(100) not null,
  EMAIL varchar(100) not null
);
