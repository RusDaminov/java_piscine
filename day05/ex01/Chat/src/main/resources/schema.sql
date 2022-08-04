DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA IF NOT EXISTS chat;
CREATE TABLE IF NOT EXISTS chat.users
(
    id       SERIAL PRIMARY KEY,
    login    VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(30)        NOT NULL
);
CREATE TABLE IF NOT EXISTS chat.chatrooms
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(30) UNIQUE                 NOT NULL,
    owner INTEGER REFERENCES chat.users (id) NOT NULL
);
CREATE TABLE IF NOT EXISTS chat.messages
(
    id           SERIAL PRIMARY KEY,
    author       INTEGER REFERENCES chat.users (id)     NOT NULL,
    room         INTEGER REFERENCES chat.chatrooms (id) NOT NULL,
    message_text VARCHAR(100)                           NOT NULL,
    message_time timestamp                              NOT NULL

);