-- ONE-TO-ONE

CREATE TABLE toothbrush(
	id serial PRIMARY key,
	color VARCHAR(255)
);

CREATE TABLE family_X(
	id serial PRIMARY key,
	name VARCHAR(255),
	brush_id int REFERENCES toothbrush(id) UNIQUE
);

INSERT INTO toothbrush (color) VALUES ('red');
INSERT INTO toothbrush (color) VALUES ('white');
INSERT INTO toothbrush (color) VALUES ('green');
INSERT INTO family_x (name, brush_id) VALUES ('Bob', 1);
INSERT INTO family_x (name, brush_id) VALUES ('Mary', 2);
INSERT INTO family_x (name, brush_id) VALUES ('Ann', 3);

SELECT * FROM family_x;
SELECT * FROM toothbrush WHERE id IN(SELECT id FROM family_x);
