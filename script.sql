create TABLE student(
	id serial primary key,
	surname VARCHAR(255),
	age integer,
	job boolean,
	avrGrade numeric(2,1)
);
select * from student;
insert into student (surname, age, job, avrGrade) values ('Ivanov', 20, false, 8.5);
insert into student (surname, age, job, avrGrade) values ('Petrov', 18, false, 7.1);
insert into student (surname, age, job, avrGrade) values ('Sidorov', 25, true, 6.5);
insert into student (surname, age, job, avrGrade) values ('Popov', 30, true, 5.9);
update student set job = true;
delete from student;