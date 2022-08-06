
CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name    VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(250)        NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.messages
(
    id           SERIAL PRIMARY KEY,
    author       BIGINT REFERENCES chat.users (id)     NOT NULL,
    message_text VARCHAR(100)                           NOT NULL,
    message_time TIMESTAMP NOT NULL DEFAULT now()
);