create database if not exists demo;
use demo;
drop table if exists `book`;
create table `book`(
	`id` int(11) not null auto_increment,
    `title` varchar(64) default null,
    `author` varchar(64) default null,
    `year` int(11) default 1970,
    `genre` varchar(64) default null,
    `is_read` boolean default false,
    primary key(`id`)
)engine=InnoDB auto_increment=1 default charset=latin1;

