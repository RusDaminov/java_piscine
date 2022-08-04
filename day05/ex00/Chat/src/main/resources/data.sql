INSERT INTO chat.users (login, password) VALUES ('Tmiranda', 'qwerty1');
INSERT INTO chat.users (login, password) VALUES ('Vaustin', 'ads');
INSERT INTO chat.users (login, password) VALUES ('Margarita', 'zxc');
INSERT INTO chat.users (login, password) VALUES ('Karina', 'rty0');
INSERT INTO chat.users (login, password) VALUES ('Mseastar', 'hjd');

INSERT INTO chat.chatrooms (name, owner) VALUES ('general', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('random', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('report', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('help', 2);
INSERT INTO chat.chatrooms (name, owner) VALUES ('news', 2);

INSERT INTO chat.messages (author, room, message_text, message_time) VALUES (3, 1, 'hello', current_timestamp);
INSERT INTO chat.messages (author, room, message_text, message_time) VALUES (2, 5, 'world', current_timestamp);
INSERT INTO chat.messages (author, room, message_text, message_time) VALUES (4, 4, 'Hi', current_timestamp);
INSERT INTO chat.messages (author, room, message_text, message_time) VALUES (2, 2, 'new message', current_timestamp);
INSERT INTO chat.messages (author, room, message_text, message_time) VALUES (1, 3, 'sos', current_timestamp);