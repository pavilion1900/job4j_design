-- MANY-TO-ONE

CREATE TABLE profession(
	id serial PRIMARY key,
	prof_name VARCHAR(255)
);

CREATE TABLE student(
	id serial PRIMARY key,
	surname VARCHAR(255),
	age INT,
	prof_id INT REFERENCES profession(id) 
);

INSERT INTO profession (prof_name) VALUES ('IT');
INSERT INTO profession (prof_name) VALUES ('Marketing');
INSERT INTO profession (prof_name) VALUES ('Economics');
INSERT INTO student (surname, age, prof_id) VALUES ('Ivanov', 20, 1);
INSERT INTO student (surname, age, prof_id) VALUES ('Petrov', 22, 2);
INSERT into student (surname, age, prof_id) VALUES ('Sidorov', 30, 3);

SELECT * FROM student;
SELECT * FROM profession;
SELECT * FROM profession WHERE id in(SELECT id FROM student);