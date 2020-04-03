
Create database RoskildeIT; 
use RoskildeIT;

drop table if exists Manager;
CREATE TABLE Manager (
  manager_id int auto_increment ,
  name varchar(50),
  phoneNumber int ,
  email varchar(50),
  PRIMARY KEY (manager_id)
);

drop table if exists login_manger;
CREATE TABLE login_manager (
  username varchar(20),
  password varchar(8),
  manager_id int,
  PRIMARY KEY (username),
  Foreign key(manager_id) references Manager(manager_id)
);

drop table if exists Teacher;
CREATE TABLE Teacher (
  teacher_id int auto_increment,
  name varchar(40),
  phoneNumber int ,
  email varchar(50),
  manager_id int,
  PRIMARY KEY (teacher_id),
  Foreign key (manager_id) references manager(manager_id)
);

drop table if exists loginTeacher;
CREATE TABLE loginTeacher (
  user_id varchar(20),
  password varchar(8),
  teacher_id int,
  PRIMARY KEY (user_id),
  Foreign key(teacher_id) references Teacher(teacher_id)
);

drop table if exists Child;
CREATE TABLE Child (
  child_cpr int,
  name varchar(40),
  pickupTime double,
  teacher_id int,
  parent_id int,
  PRIMARY KEY (child_cpr),
  Foreign Key(teacher_id) references Teacher(teacher_id)
);

drop table if exists PostNum;
CREATE TABLE PostNum (
  zip int,
  city varchar(50),
 Primary key(zip)
);

drop table if exists Parent;
CREATE TABLE Parent (
  parent_id int auto_increment,
  DadName varchar(50),
  MomName varchar(50),
  address varchar(50),
  phoneNumber int,
  zip int,
  email varchar(50),
  PRIMARY KEY (parent_id)
);

drop table if exists Schedule;
CREATE TABLE Schedule (
  shift_id int auto_increment,
  teacher_id int,
  PRIMARY KEY (shift_id),
  Foreign key(teacher_id) references Teacher(teacher_id)
);

drop table if exists schedule_time;
CREATE TABLE schedule_time (
  time_id int auto_increment,
  shift_id int,
  date varchar(40),
  start double,
  end double,
  duration double,
  PRIMARY KEY (time_id),
  Foreign key(shift_id) references Schedule(shift_id)
);


drop table if exists WaitingList;
CREATE TABLE WaitingList (
  cpr int,
  name varchar(50),
  phoneNumber int ,
  PRIMARY KEY (cpr)
);

drop table if exists phonelist;
CREATE TABLE phonelist (
  phoneNumber int,
  name varchar(50),
  PRIMARY KEY (phoneNumber)
);

ALTER TABLE child ADD foreign key(parent_id) references parent(parent_id);

