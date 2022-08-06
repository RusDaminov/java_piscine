DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS users
(
    id       SERIAL PRIMARY KEY,
    name    VARCHAR(30) UNIQUE NOT NULL,
    password VARCHAR(250)        NOT NULL
);