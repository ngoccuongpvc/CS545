INSERT INTO users (id, name, email, password) VALUES (111, 'Ronaldo', 'ronaldo@gmail.com', '$2a$12$6kRfLC5UxQ3mhKXtcX3EZ.nDgkQH4Y0ERswZWTsIkIapz7n0lDbQW');
INSERT INTO users (id, name, email, password) VALUES (112, 'Messi', 'messi@gmail.com', '$2a$12$HW0E0HBVTEmMqfzoEirNXOQGfgxOQrrIow9NM0NP7QWSEgNp2M4bm');
INSERT INTO users (id, name, email, password) VALUES (113, 'Doraemon', 'doraemon@gmail.com', '$2a$12$gloWkH7CNmQJSH5ebef7AuM2sUZHZA5udYCPa0DtxMgLNrwB7wREi');

INSERT INTO post (user_id, author, content, title) VALUES (111, 'MrA', 'Some thing interesting', 'SOS');
INSERT INTO post (user_id, author, content, title) VALUES (111, 'X', 'The new champion', 'HOT!');
INSERT INTO post (user_id, author, content, title) VALUES (112, 'Bob', 'Messi and his cups', 'GOAT');

INSERT INTO comment (id, post_id, name) VALUES(1, 1, 'user_a');
INSERT INTO comment (id, post_id, name) VALUES(2, 1, 'user_b');
INSERT INTO comment (id, post_id, name) VALUES(3, 1, 'user_a');

INSERT INTO role (id, role) VALUES (1, 'USER');
INSERT INTO role (id, role) VALUES (2, 'ADMIN');

INSERT INTO users_roles (user_id, roles_id) VALUES (111, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (111, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (112, 1);