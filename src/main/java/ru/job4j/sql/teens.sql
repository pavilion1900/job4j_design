 create table teens(
 	name VARCHAR(20),
 	gender VARCHAR(10)
 );

 insert into teens (name, gender) values ('Bob', 'male'), ('Stiv', 'male'), ('Jhon', 'male');
 insert into teens (name, gender) values ('Mary', 'female'), ('Kate', 'female'), ('Ann', 'female');

 select t1.name, t2.name
 from teens t1 cross join teens t2
 where t1.gender = 'male' and t2.gender = 'female';