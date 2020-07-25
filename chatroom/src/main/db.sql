create database chatroom;
use chatroom;


drop table if exists user;
create table user(
    userId int primary key auto_increment,
    name varchar(50) unique ,
    password varchar(50),
    nickName varchar(50),
    lastLogout datetime -- 表示上次退出的时间，同来实现历史记录功能
);

drop table if exists channel;
create table channel (
    channelId int primary key auto_increment,
    channelName varchar(50)
);

drop table if exists message;
create table message (
    messageId int primary key auto_increment,
    userId int, -- 谁发送的消息.
    channelId int,
    context text,  -- 消息正文
    sendTime datetime -- 消息的发送时间.
);
