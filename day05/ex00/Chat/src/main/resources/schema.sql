DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA IF NOT EXISTS chat;
CREATE table if not exists chat.users (
    id serial primary key,
    login varchar(30) unique not null,
    password varchar(30) not null
    );
create table if not exists chat.chatrooms (
    id serial primary key,
    name varchar(30) UNIQUE not null,
    owner INTEGER REFERENCES chat.users(id) NOT NULL
    );
create table if not exists chat.messages (
    id serial primary key,
    author INTEGER REFERENCES chat.users(id) not null,
    room INTEGER REFERENCES chat.chatrooms(id) not null ,
    message_text varchar(100) not null ,
    message_time timestamp not null

    );