-- MANY-TO-ONE

create TABLE profession(
	id serial PRIMARY key,
	prof_name VARCHAR(255)
);

create TABLE student(
	id serial PRIMARY key,
	surname VARCHAR(255),
	age INT,
	prof_id INT REFERENCES profession(id) 
);

insert into profession (prof_name) values ('IT');
insert into profession (prof_name) values ('Marketing');
insert into profession (prof_name) values ('Economics');
insert into profession (prof_name) values ('Statistics');
insert into profession (prof_name) values ('History');
insert into student (surname, age, prof_id) values ('Ivanov', 20, 1);
insert into student (surname, age, prof_id) values ('Petrov', 22, 2);
insert into student (surname, age, prof_id) values ('Sidorov', 30, 3);

select * from student st join profession pr on (st.prof_id = pr.id);
select st.surname, st.age, pr.prof_name from student st join profession pr on (st.prof_id = pr.id);
select st.surname, st.age, pr.prof_name from student st join profession pr on (st.prof_id = pr.id)
where st.age > 20;
select st.surname, st.age, pr.prof_name from student st join profession pr on (st.prof_id = pr.id)
where pr.prof_name like 'Mark%';