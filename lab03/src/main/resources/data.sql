INSERT INTO users (id, name) VALUES (111, 'Ronaldo');
INSERT INTO users (id, name) VALUES (112, 'Messi');
INSERT INTO users (id, name) VALUES (113, 'Doraemon');

INSERT INTO post (user_id, author, content, title) VALUES (111, 'MrA', 'Some thing interesting', 'SOS');
INSERT INTO post (user_id, author, content, title) VALUES (111, 'X', 'The new champion', 'HOT!');
INSERT INTO post (user_id, author, content, title) VALUES (112, 'Bob', 'Messi and his cups', 'GOAT');

INSERT INTO comment (id, post_id, name) VALUES(1, 1, 'user_a');
INSERT INTO comment (id, post_id, name) VALUES(2, 1, 'user_b');
INSERT INTO comment (id, post_id, name) VALUES(3, 1, 'user_a');