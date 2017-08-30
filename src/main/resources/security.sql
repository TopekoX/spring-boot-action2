drop table s_user_role;
drop table s_user;
drop table s_role;

create table s_user (
id int auto_increment primary key,
username varchar(255) not null,
password varchar(255) not null,
active boolean,
unique (username)
);

insert into s_user (username, password, active)
values
("ucup","topeko",true),
("aco","123",true);

create table s_role (
id varchar(50) primary key,
nama varchar(255) not null
);

insert into s_role (id, nama)
values
("adm", "ROLE_ADMIN"),
("stf","ROLE_STAF");

create table s_user_role (
id_user varchar(50) primary key,
id_role varchar(255) not null
);

insert into s_user_role (id_user, id_role)
values
(1, "adm"),
(2,"stf");

