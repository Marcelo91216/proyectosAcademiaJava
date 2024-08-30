create database if not exists library;
use library;
drop table if exists book;
create table book(
	id int(11) not null auto_increment,
    book_name varchar(64) default null,
    edition varchar(64) default null,
    author varchar(64) default null,
    sales int(11) default 0,
    primary key(id)
)engine=InnoDB auto_increment=1 default charset=latin1;