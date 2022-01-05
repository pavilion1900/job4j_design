 create TABLE devices(
 	id serial PRIMARY key,
 	name VARCHAR(255),
 	price numeric
 );

 create TABLE people(
 	id serial PRIMARY key,
 	name VARCHAR(255)
 );

 create TABLE devices_people(
 	id serial PRIMARY key,
 	device_id int REFERENCES devices (id),
 	people_id int REFERENCES people (id)
 );

 insert into devices (name, price) values ('mouse', 570.35), ('mouse', 630.12), ('mouse', 850.55);
 insert into devices (name, price) values ('printer', 14500.04), ('printer', 10500.24), ('printer', 16320.84);
 insert into devices (name, price) values ('mouse pad', 1100.80), ('mouse pad', 2999.90), ('mouse pad', 1500.99);
 insert into people (name) values ('Ivanov'), ('Petrov'), ('Sidorov');

 insert into devices_people (device_id, people_id) values (1, 1), (1, 2), (1, 3);
 insert into devices_people (device_id, people_id) values (2, 1), (2, 2);
 insert into devices_people (device_id, people_id) values (3, 3);
 insert into devices_people (device_id, people_id) values (4, 2), (4, 3);
 insert into devices_people (device_id, people_id) values (5, 2);
 insert into devices_people (device_id, people_id) values (6, 1), (6, 3);
 insert into devices_people (device_id, people_id) values (7, 1), (7, 2);
 insert into devices_people (device_id, people_id) values (8, 3);
 insert into devices_people (device_id, people_id) values (9, 2), (9, 3);

 select devices.name, count(*), round(avg(devices.price), 2)
 from devices_people dp
 join devices on dp.device_id = devices.id
 group by devices.name;

 select people.name, count(devices.name), round(avg(devices.price), 2)
 from devices_people dp
 join people on dp.people_id = people.id
 join devices on dp.device_id = devices.id
 group by people.name;

 select people.name, count(devices.name), round(avg(devices.price), 2)
 from devices_people dp
 join people on dp.people_id = people.id
 join devices on dp.device_id = devices.id
 group by people.name
 having round(avg(devices.price), 2) > 5000;
