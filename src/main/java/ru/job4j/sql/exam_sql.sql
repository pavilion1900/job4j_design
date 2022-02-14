SELECT * FROM fauna WHERE name LIKE '%fish%';
SELECT * FROM fauna WHERE avr_age BETWEEN 10000 AND 21000;
SELECT * FROM fauna WHERE discovery_date is null;
SELECT * FROM fauna WHERE discovery_date < '01.01.1950';


 create table company(
 	id integer NOT null,
 	name character VARYING,
 	constraint company_pkey PRIMARY key (id)
 );

 create table person(
 	id integer NOT null,
 	name character VARYING,
 	company_id integer REFERENCES company (id),
 	constraint person_pkey PRIMARY key (id)
 );

 insert into company (id, name) values (1, 'IBM'), (2, 'Meta'), (3, 'Microsoft'), (4, 'Luxsoft'),
 (5, 'Apple'), (6, 'Sumsuns'), (7, 'EPAM');

 insert into person (id, name, company_id) values (1, 'Ivanov', 1), (2, 'Petrov', 1),
 (3, 'Sidorov', 2),(4, 'Frolov', 2), (5, 'Black', 2),(6, 'Mohnach', 2),
 (7, 'Korolenko', 3),
 (8, 'Beruk', 5),(9, 'Pochta', 5), (10, 'Sereda', 5), (11, 'Boloto', 5),(12, 'Sychevich', 5),
 (13, 'Dulcev', 4),(14, 'Sigunov', 4), (15, 'Razgonov', 4), (16, 'Kravchenko', 4),(17, 'Pikulitckiy', 4),
 (18, 'Popov', 7);

-- имена всех person, которые не состоят в компании с id = 5;

 select name from person where company_id != 5;

-- название компании для каждого человека.

 select pers.name, com.name from person pers
 join company com on pers.company_id = com.id;

-- название компании с максимальным количеством человек + количество человек в этой компании

 select com.name, count(*)
 from person pers
 join company com on pers.company_id = com.id
 group by com.name
 having count(*) = (
 	select count(*) from person
 	group by company_id
 	order by count(*) desc
 	limit 1
 )