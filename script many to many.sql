-- MANY-TO=MANY

CREATE TABLE car(
	id serial PRIMARY key,
	model VARCHAR(255)
);

CREATE TABLE driver(
	id serial PRIMARY key,
	surname VARCHAR(255)
);

CREATE TABLE car_driver(
	id serial PRIMARY key,
	car_id int REFERENCES car(id),
	driver_id int REFERENCES driver(id)
);

INSERT INTO car (model) VALUES ('BMW');
INSERT INTO car (model) VALUES ('WV');
INSERT INTO car (model) VALUES ('Jeep');
INSERT into driver (surname) VALUES ('Ivanov');
INSERT INTO driver (surname) VALUES ('Petrov');
INSERT INTO driver (surname) VALUES ('Sidorov');
INSERT INTO car_driver (car_id, driver_id) VALUES (1, 1);
INSERT INTO car_driver (car_id, driver_id) VALUES (1, 2);
INSERT INTO car_driver (car_id, driver_id) VALUES (1, 3);
INSERT INTO car_driver (car_id, driver_id) VALUES (2, 1);
INSERT INTO car_driver (car_id, driver_id) VALUES (2, 3);
INSERT INTO car_driver (car_id, driver_id) VALUES (3, 1);

SELECT * FROM car;
SELECT * FROM driver;
SELECT * FROM driver WHERE id in(SELECT driver_id FROM car_driver);
SELECT * FROM car WHERE id in(SELECT car_id FROM car_driver);