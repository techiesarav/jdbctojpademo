
create table IF NOT EXISTS  person(
  id integer not null AUTO_INCREMENT,
  name varchar(255),
  location varchar(255),
  birth_date timestamp
);

create table IF NOT EXISTS course(
  id integer not null AUTO_INCREMENT,
  name varchar(255) not null,
  created_date timestamp,
  updated_date timestamp,
  primary key(id)
);

create table IF NOT EXISTS passport(
  id integer not null AUTO_INCREMENT,
  number varchar(255) not null,
  primary key(id)
);

create table IF NOT EXISTS student(
  id integer not null AUTO_INCREMENT,
  name varchar(255) not null,
  passport_id integer,
  primary key(id)
);

create table IF NOT EXISTS review(
  id integer not null AUTO_INCREMENT,
  rating integer not null,
  description varchar(255) not null,
  course_id integer not null,
  primary key(id)
);

create table IF NOT EXISTS student_course(
  student_id integer not null AUTO_INCREMENT,
  course_id integer not null AUTO_INCREMENT
);