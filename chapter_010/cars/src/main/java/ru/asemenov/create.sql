create table body (
  id serial primary key,
  name varchar(100) NOT NULL UNIQUE
);

create table engine (
  id serial primary key,
  name varchar(100) NOT NULL UNIQUE
);

create table mark (
  id serial primary key,
  name varchar(100) NOT NULL UNIQUE
);

create table model (
  id serial primary key,
  name varchar(100) NOT NULL UNIQUE,
  mark_id int references mark(id)
);

create table transmission (
  id serial primary key,
  name varchar(100) NOT NULL UNIQUE
);

create table car (
  id serial primary key,
  mark_id int references mark(id),
  model_id int references model(id),
  body_id int references body(id),
  year int,
  distance int,
  transmission_id int references transmission(id),
  engine_id int references engine(id),
  engine_capacity DOUBLE PRECISION,
  price int
);

INSERT INTO body (name) VALUES ('Седан');
INSERT INTO body (name) VALUES ('Кабриолет');
INSERT INTO body (name) VALUES ('Хэтчбек');
INSERT INTO body (name) VALUES ('Универсал');

INSERT INTO engine (name) VALUES ('Бензиновый');
INSERT INTO engine (name) VALUES ('Дизельный');

INSERT INTO transmission (name) VALUES ('Механика');
INSERT INTO transmission (name) VALUES ('Автомат');

INSERT INTO mark (name) VALUES ('AUDI');
INSERT INTO mark (name) VALUES ('Chevrolet');
INSERT INTO mark (name) VALUES ('ВАЗ');

INSERT INTO model (name, mark_id) VALUES ('A6', '1');
INSERT INTO model (name, mark_id) VALUES ('A8', '1');
INSERT INTO model (name, mark_id) VALUES ('Q5', '1');
INSERT INTO model (name, mark_id) VALUES ('Aveo', '2');
INSERT INTO model (name, mark_id) VALUES ('Cruze', '2');
INSERT INTO model (name, mark_id) VALUES ('Lacetti', '2');
INSERT INTO model (name, mark_id) VALUES ('2107', '3');
INSERT INTO model (name, mark_id) VALUES ('Гранта', '3');
INSERT INTO model (name, mark_id) VALUES ('Vesta', '3');

INSERT INTO car (mark_id, model_id, body_id, year, distance, transmission_id, engine_id, engine_capacity, price) VALUES ('2','4','3','2005','178000','1','1','1.4','100000');
INSERT INTO car (mark_id, model_id, body_id, year, distance, transmission_id, engine_id, engine_capacity, price) VALUES ('1','2','4','2010','56000','2','2','2.0','630000');
INSERT INTO car (mark_id, model_id, body_id, year, distance, transmission_id, engine_id, engine_capacity, price) VALUES ('3','8','4','1990','20','2','1','6.0','31000');

create table users (
  id serial primary key,
  name varchar(100) NOT NULL,
  login varchar(10) NOT NULL UNIQUE,
  password varchar(20) NOT NULL
);

INSERT INTO users (name, login, password) VALUES ('Alex','admin','password');
INSERT INTO users (name, login, password) VALUES ('AlexUser','alex','password');
