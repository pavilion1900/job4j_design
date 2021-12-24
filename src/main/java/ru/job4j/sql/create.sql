CREATE TABLE role(
	id serial PRIMARY key,
	name VARCHAR(50)
);

CREATE TABLE rules(
	id serial PRIMARY key,
	name VARCHAR(50),
	description text
);

CREATE TABLE role_rules(
	id serial PRIMARY key,
	role_id int REFERENCES role(id),
	rules_id int REFERENCES rules(id)
);

CREATE TABLE category(
	id serial PRIMARY key,
	name VARCHAR(50)
);

CREATE TABLE state(
	id serial PRIMARY key,
	name VARCHAR(50)
);

CREATE TABLE users(
	id serial PRIMARY key,
	surname VARCHAR(50),
	role_id int REFERENCES role(id)
);

CREATE TABLE item(
	id serial PRIMARY key,
	name VARCHAR(50),
	users_id int REFERENCES users(id),
	category_id int REFERENCES category(id),
	state_id int REFERENCES state(id)
);

CREATE TABLE comments(
	id serial PRIMARY key,
	description text,
	item_id int REFERENCES item(id)
);

CREATE TABLE attachs(
	id serial PRIMARY key,
	name VARCHAR(50),
	item_id int REFERENCES item(id)
);