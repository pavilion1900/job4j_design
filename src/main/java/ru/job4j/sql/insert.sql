INSERT INTO role (name) values ('Doctor');
INSERT INTO role (name) values ('Driver');
INSERT INTO role (name) values ('Student');

INSERT INTO rules (name, description) values ('first', 'be in time');
INSERT INTO rules (name, description) values ('second', 'work everyday');
INSERT INTO rules (name, description) values ('third', 'work hard');

INSERT INTO role_rules (role_id, rules_id) values (1, 1);
INSERT INTO role_rules (role_id, rules_id) values (1, 3);
INSERT INTO role_rules (role_id, rules_id) values (2, 2);
INSERT INTO role_rules (role_id, rules_id) values (3, 1);
INSERT INTO role_rules (role_id, rules_id) values (3, 2);

INSERT INTO users (surname, role_id) VALUES ('Ivanov', 2);
INSERT INTO users (surname, role_id) VALUES ('Petrov', 1);
INSERT INTO users (surname, role_id) VALUES ('Sidorov', 3);
INSERT INTO users (surname, role_id) VALUES ('Samonov', 2);

INSERT INTO category (name) VALUES ('usual');
INSERT INTO category (name) VALUES ('unusual');

INSERT INTO state (name) VALUES ('read');
INSERT INTO state (name) VALUES ('unread');
INSERT INTO state (name) VALUES ('done');

INSERT INTO item (name, users_id, category_id, state_id) VALUES ('repeat lesson', 1, 1, 1);
INSERT INTO item (name, users_id, category_id, state_id) VALUES ('do exercises', 2, 2, 2);
INSERT INTO item (name, users_id, category_id, state_id) VALUES ('visit hightshcool', 3, 1, 3);

INSERT INTO comments (description, item_id) VALUES ('lesson on page 55', 1);
INSERT INTO comments (description, item_id) VALUES ('do exercises before 19.00', 2);
INSERT INTO comments (description, item_id) VALUES ('every day', 3);

INSERT INTO attachs (name, item_id) VALUES ('img_001', 1);
INSERT INTO attachs (name, item_id) VALUES ('img_010', 2);
INSERT INTO attachs (name, item_id) VALUES ('img_101', 3);