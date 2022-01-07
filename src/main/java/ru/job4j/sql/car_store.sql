 create table car_body(
 	id serial primary key,
 	name VARCHAR(255)
 );

 create table engine(
 	id serial primary key,
 	name VARCHAR(255)
 );

 create table gearbox(
 	id serial primary key,
 	name VARCHAR(255)
 );

 create table car(
 	id serial primary key,
 	name VARCHAR(255),
 	car_body_id int REFERENCES car_body(id),
 	engine_id int REFERENCES engine(id),
 	gearbox_id int REFERENCES gearbox(id)
 );

  insert into car_body(name) values ('Кабриолет'), ('Хэтчбэк'), ('Лимузин'), ('Минивэн'), ('Родстер');
  insert into engine (name) values ('Рядный'), ('V-типа'), ('Роторный'), ('Радиальный ');
  insert into gearbox (name) values ('Механическая'), ('Автоматическая '), ('Вариативная');
  insert into car (name, car_body_id, engine_id, gearbox_id)
  values ('BMW', 1, 2, 2), ('BMW', 2, 2, 1), ('VW', 4, 3, 1), ('VW', 3, 3, 1),
  ('Opel', 2, 1, 1), ('Opel', 1, 1, 2), ('Toyota', 1, 2, 1), ('Toyota', 4, 2, 2);

 select car.name car_name, body.name car_body, eng.name engine, gear.name gearbox
 from car
 join car_body body on (car.car_body_id = body.id)
 join engine eng on (car.engine_id = eng.id)
 join gearbox gear on (car.gearbox_id = gear.id);

 select body.name car_body, eng.name engine, gear.name gearbox
 from car
 full join car_body body on (car.car_body_id = body.id)
 full join engine eng on (car.engine_id = eng.id)
 full join gearbox gear on (car.gearbox_id = gear.id)
 where car.name is null;