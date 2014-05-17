CREATE DATABASE `freightbit`;

create table freightbit.client (
   clientId BIGINT not null,
   name VARCHAR(50) not null,
   code VARCHAR(10) not null,
   descripton VARCHAR(255),
   status INTEGER not null,
   primary key (clientId)
);



create table freightbit.user (
   clientId BIGINT not null,  
   userId BIGINT not null,
   username VARCHAR(50) not null unique,
   password VARCHAR(255) not null,
   title VARCHAR(255),
   email VARCHAR(255) not null,
   firstName VARCHAR(255),
   lastName VARCHAR(255),
   creationDate BIGINT not null,
   modifiedDate BIGINT not null,
   lastVisitDate BIGINT not null,
   status INTEGER not null,
   primary key (userId)
);


create table freightbit.group (
   clientId BIGINT not null, 
   groupId BIGINT not null,
   name VARCHAR(50) not null unique,
   description VARCHAR(255),
   creationDate BIGINT not null,
   modifiedDate BIGINT not null,
   primary key (groupId)
);



create table freightbit.permission (
   clientId BIGINT not null, 
   permissionId BIGINT not null,
   name VARCHAR(50) not null unique,
   description VARCHAR(255),
   creationDate BIGINT not null,
   modifiedDate BIGINT not null,
   primary key (permissionId)
);


create table freightbit.groupUser (
   clientId BIGINT not null,
   groupUserId BIGINT not null,
   userId BIGINT not null,
   groupId BIGINT not null,
   primary key (groupUserId)
);


create table freightbit.permissionUserGroup (
   clientId BIGINT not null, 
   permissionId BIGINT not null,
   userId BIGINT,
   groupId BIGINT,
   projectId BIGINT,
   value BIGINT,
   primary key (permissionId)
);