INSERT INTO chat.users (login, password) VALUES ('Abernita', 'qwert');
INSERT INTO chat.users (login, password) VALUES ('Biba', 'ads');
INSERT INTO chat.users (login, password) VALUES ('Boba', 'zxc');
INSERT INTO chat.users (login, password) VALUES ('Abobus`', 'rty0');
INSERT INTO chat.users (login, password) VALUES ('John', 'hjd');

INSERT INTO chat.chatrooms (name, owner) VALUES ('general', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('random', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('report', 1);
INSERT INTO chat.chatrooms (name, owner) VALUES ('help', 2);
INSERT INTO chat.chatrooms (name, owner) VALUES ('news', 2);

INSERT INTO chat.messages (author, room, message_text) VALUES (3, 1, 'hello');
INSERT INTO chat.messages (author, room, message_text) VALUES (2, 5, 'world');
INSERT INTO chat.messages (author, room, message_text) VALUES (4, 4, 'Hi');
INSERT INTO chat.messages (author, room, message_text) VALUES (2, 2, 'new message');
INSERT INTO chat.messages (author, room, message_text) VALUES (1, 3, 'sos');