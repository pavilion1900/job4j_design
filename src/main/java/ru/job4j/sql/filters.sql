 create table type(
 	id serial primary key,
 	name VARCHAR(255)
 );

 create table product(
 	id serial primary key,
 	name VARCHAR(255),
 	type_id int REFERENCES type(id),
 	expired_date date,
 	price numeric
 );

 insert into type (name) values ('СЫР'), ('МОЛОКО'), ('МОРОЖЕНОЕ');
 insert into product (name, type_id, expired_date, price) values ('Сыр плавленный', 1, '01-Jan-22', 500.35);
 insert into product (name, type_id, expired_date, price) values ('Сыр плавленный', 1, '20-Jan-22', 520.35);
 insert into product (name, type_id, expired_date, price) values ('Сыр плавленный', 1, '25-Jan-22', 550.35);
 insert into product (name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '02-Feb-22', 1500.67);
 insert into product (name, type_id, expired_date, price) values ('Сыр моцарелла', 1, '12-Feb-22', 1100.40);
 insert into product (name, type_id, expired_date, price) values ('Молоко 0,5%', 2, '06-Jan-22', 200.40);
 insert into product (name, type_id, expired_date, price) values ('Молоко 0,5%', 2, '10-Jan-22', 230.40);
 insert into product (name, type_id, expired_date, price) values ('Молоко 1,0%', 2, '02-Jan-22', 300.22);
 insert into product (name, type_id, expired_date, price) values ('Молоко 1,0%', 2, '11-Jan-22', 330.22);
 insert into product (name, type_id, expired_date, price) values ('Мороженое огонек', 3, '09-Jan-22', 350.12);
 insert into product (name, type_id, expired_date, price) values ('Мороженое снежок', 3, '08-Jan-22', 370.12);

 select * from product
 join type on (product.type_id = type.id)
 where type.name = 'СЫР';

 select * from product
 where lower(product.name) like '%мороженое%';

 select * from product
 where current_date > product.expired_date;

 select * from product
 where product.price = (select max(product.price) from product);

 select type.name, count(*) from product
 join type on (product.type_id = type.id)
 group by type.name;

 select * from product
 join type on (product.type_id = type.id)
 where type.name in ('СЫР', 'МОЛОКО');

 select type.name, count(*)
 from product
 join type on (product.type_id = type.id)
 group by type.name
 having count(*) < 10;

 select product.name, type.name from product
 join type on (product.type_id = type.id);