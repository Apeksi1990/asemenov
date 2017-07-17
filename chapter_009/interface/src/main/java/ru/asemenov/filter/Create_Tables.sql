create table roles (
id serial primary key,
name varchar(25) UNIQUE
);

create table sec_users (
id serial primary key,
name varchar(25) NOT NULL,
login varchar(25) NOT NULL UNIQUE,
password varchar(25) NOT NULL,
email varchar(50) UNIQUE,
create_date TimeStamp,
role_id int references roles(id)
);

create table countries (
  id serial primary key,
  name varchar(30) UNIQUE NOT NULL
);

create table cities (
  id serial primary key,
  name varchar(30) UNIQUE NOT NULL,
  country_id int references countries(id) NOT NULL
);

ALTER TABLE sec_users ADD city_id int references cities(id);