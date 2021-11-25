insert into fauna(name, avg_age, discovery_date) values ('catfish', 231424, '1900-12-21');
insert into fauna(name, avg_age, discovery_date) values ('frog', 6456, '1950-12-21');
insert into fauna(name, avg_age, discovery_date) values ('horsefish', 56455, '2000-12-21');
insert into fauna(name, avg_age, discovery_date) values ('fish', 18434, '1900-12-21');
insert into fauna(name, avg_age, discovery_date) values ('lion', 90424, '1950-01-01');
insert into fauna(name, avg_age, discovery_date) values ('turtle', 9999999, '1900-03-16');
insert into fauna(name, avg_age, discovery_date) values ('monkey', 20000, null);
insert into fauna(name, avg_age, discovery_date) values ('neanderthal', 89878, '2021-03-16');


select * from fauna where name like '%fish' or name like '%fish%' or name like 'fish%'; 
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950-01-01';