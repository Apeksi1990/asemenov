create table address (
id serial primary key,
name varchar(100) UNIQUE
);

create table role (
id serial primary key,
name varchar(50) UNIQUE
);

create table musictype (
  id serial primary key,
  name varchar(50) UNIQUE
);

create table users (
  id serial primary key,
  name varchar(25) NOT NULL,
  login varchar(25) NOT NULL UNIQUE,
  password varchar(25) NOT NULL,
  address_id int references address(id),
  role_id int references role(id)
);

create table user_music (
  user_id int references users(id),
  music_id int references musictype(id)
);

insert into role (name) values ('user');
insert into role (name) values ('mandator');
insert into role (name) values ('admin');

insert into address (name) values ('Москва');
insert into address (name) values ('Сочи');
insert into address (name) values ('Владивосток');

insert into musictype (name) values ('RAP');
insert into musictype (name) values ('ROCK');
insert into musictype (name) values ('METAL');

insert into users (name, login, password, address_id, role_id) values ('Admin', 'admin', 'password', '1', '3');
insert into users (name, login, password, address_id, role_id) values ('Alex', 'alex', 'password', '2', '1');

insert into user_music (user_id, music_id) values ('1', '1');
insert into user_music (user_id, music_id) values ('1', '3');
insert into user_music (user_id, music_id) values ('2', '2');