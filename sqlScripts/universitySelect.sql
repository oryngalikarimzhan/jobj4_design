select * from universities;
select * from students;
select name, course, speciality from students;
select * from students where name = 'AB';
select * from students where course != 2;
select * from students where name is not null;
select * from students where enroll_date < '01.09.2020';
select * from students where name like 'D%'; 
select * from students where name like 'D%' and course > 2;
select * from students where name like 'D%' or course > 2; 
select * from students order by course asc;
select distinct course from students; 
select * from students limit 5; 
