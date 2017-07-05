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