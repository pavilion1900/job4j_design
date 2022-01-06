 create table departmens(
 	id serial primary key,
 	name VARCHAR(255)
 );

 create table employees(
 	id serial primary key,
 	name VARCHAR(255),
 	departmens_id int REFERENCES departmens(id)
 );

 insert into departmens (name) values ('IT'), ('Sales'), ('Market'), ('HR');
 insert into employees (name, departmens_id) values ('Ivanov', 1), ('Petrov', 1), ('Sidorov', null);
 insert into employees (name, departmens_id) values ('Frolov', 2), ('Tkach', null), ('Dudal', 3);

 select * from employees emp
 left join departmens dep on (emp.departmens_id = dep.id);

 select * from employees emp
 right join departmens dep on (emp.departmens_id = dep.id);

 select * from employees emp
 full join departmens dep on (emp.departmens_id = dep.id);

 select * from employees cross join departmens;

 select * from departmens dep
 left join employees emp on (dep.id = emp.departmens_id)
 where emp.name is null;

 select emp.name, emp.departmens_id, dep.name
 from employees emp
 left join departmens dep on (emp.departmens_id = dep.id);

 select emp.name, emp.departmens_id, dep.name
 from departmens dep
 right join employees emp on (emp.departmens_id = dep.id);