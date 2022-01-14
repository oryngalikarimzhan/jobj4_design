create table passport(
    id serial primary key,
    seria int,
    number int
);

create table people(
    id serial primary key,
    name varchar(255),
    passport_id int references passport(id) unique
);

insert into passport(seria, number) values (1111, 123456);
insert into passport(seria, number) values (1112, 123457);
insert into passport(seria, number) values (1113, 123458);

insert into people(name, passport_id) values ('Ivan', 1);
insert into people(name, passport_id) values ('Boris', 2);
insert into people(name, passport_id) values ('Petr', 3);
insert into people(name) values ('Vasya');
insert into people(name) values ('Anya');

---------------------------------------------------------------------------------------

create table position(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    position_id int references position(id)
);

insert into position(name) values ('programmer');
insert into position(name) values ('project manager');
insert into position(name) values ('director');

insert into employees(name, position_id) values('Boris', 1);
insert into employees(name, position_id) values('Ivan', 1);
insert into employees(name, position_id) values('Kiril', 1);
insert into employees(name, position_id) values ('Marina', 2);
insert into employees(name, position_id) values ('Pers', 3);

insert into employees(name) values ('Alexander');


---------------------------------------------------------------------------------------

create table students(
    id serial primary key, name text
);

create table subjects(
    id serial primary key, name text
);

create table students_subjects(
    id serial primary key, 
    mark float, 
    std_id int references students(id), 
    sbj_id int references subjects(id)
);

insert into students(name) values ('Аня'), ('Ваня'), ('Боря');
insert into subjects(name) values ('Математика'), ('Русский'), ('Информатика');
insert into students_subjects(std_id, sbj_id, mark) values (1, 1, 5), (1, 2, 5), (1, 3, 5);
insert into students_subjects(std_id, sbj_id, mark) values (2, 1, 5), (2, 2, 4), (2, 3, 4);
insert into students_subjects(std_id, sbj_id, mark) values (3, 1, 3), (3, 2, 5), (3, 3, 3);

select avg(mark) from students_subjects;
select min(mark) from students_subjects;
select max(mark) from students_subjects;

select s.name, avg(ss.mark) from students_subjects as ss join subjects s on ss.sbj_id = s.id 
group by s.name;
select s.name, avg(ss.mark) from students_subjects as ss join students s on ss.std_id = s.id 
group by s.name;

select s.name, avg(ss.mark) from students_subjects as ss join subjects s on ss.sbj_id = s.id group by s.name 
having avg(ss.mark) > 4.2;

---------------------------------------------------------------------------------------

create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices(name, price) values ('computer', 15000);
insert into devices(name, price) values ('smartphone', 8000);
insert into devices(name, price) values ('ereader', 5000);
insert into devices(name, price) values ('headphone', 4000);
insert into devices(name, price) values ('watch', 6000);
insert into devices(name, price) values ('laptop', 13000);
insert into devices(name, price) values ('tab', 8000);

insert into people(name) values ('Katya');
insert into people(name) values ('Nikita');
insert into people(name) values ('Oleg');
insert into people(name) values ('Kostya');
insert into people(name) values ('Pasha');
insert into people(name) values ('Misha');

insert into devices_people(people_id, device_id) values (1, 1);
insert into devices_people(people_id, device_id) values (1, 2);
insert into devices_people(people_id, device_id) values (1, 3);
insert into devices_people(people_id, device_id) values (1, 4);
insert into devices_people(people_id, device_id) values (2, 1);
insert into devices_people(people_id, device_id) values (3, 1);
insert into devices_people(people_id, device_id) values (4, 1);
insert into devices_people(people_id, device_id) values (5, 1);
insert into devices_people(people_id, device_id) values (6, 1);
insert into devices_people(people_id, device_id) values (4, 2);
insert into devices_people(people_id, device_id) values (3, 2);
insert into devices_people(people_id, device_id) values (2, 2);
insert into devices_people(people_id, device_id) values (5, 2);
insert into devices_people(people_id, device_id) values (6, 2);


select avg(price) from devices;

select p.name, avg(d.price) from devices as d 
join people as p
join devices_people as dp
on dp.people_id = p.id
on dp.device_id = d.id
group by p.name; 

select p.name, avg(d.price) from devices as d 
join people as p
join devices_people as dp
on dp.people_id = p.id
on dp.device_id = d.id
group by p.name
having avg(d.price) > 9000; 

--------------------------------------------------------------------------

create table owners(
    id serial primary key,
    name varchar(255)
);

create table devices(
    id serial primary key,
    name varchar(255),
    owner_id int references owners(id)
);

insert into owners(name) values ('Owner 1');
insert into owners(name) values ('Owner 2');
insert into owners(name) values ('Owner 3');

insert into devices(name, owner_id) values ('Device 1', 1);
insert into devices(name, owner_id) values ('Device 2', 2);
insert into devices(name, owner_id) values ('Device 3', 3);
insert into devices(name, owner_id) values ('Device 4', null);
insert into devices(name, owner_id) values ('Device 5', null);
insert into devices(name, owner_id) values ('Device 6', 1);

select * from devices d left join owners o on d.owner_id = o.id;
select * from devices d left join owners o on d.owner_id = o.id where o.id is null;
select * from owners o left join devices d on o.id = d.owner_id;

select * from devices d left join owners o on d.owner_id = o.id;
select * from owners o right join devices d on d.owner_id = o.id;

select * from owners o left join devices d on o.id = d.owner_id;
select * from devices d right join owners o on d.owner_id = o.id;

select * from devices d full join owners o on d.owner_id = o.id;

select * from devices d left join owners o on d.owner_id = o.id
union
select * from devices d right join owners o on d.owner_id = o.id;


select * from devices d cross join owners o;

------------------------------------------------------------------------------

create table numbers(
    num int unique
);

insert into numbers(num) values (1);
insert into numbers(num) values (2);
insert into numbers(num) values (3);

select n1.num as a, n2.num as b, (n1.num * n2.num) as "a*b=" from numbers n1 cross join numbers n2;

-----------------------------------------------------------------


create table departments(
	id serial primary key,
	name varchar(255)
);

create table employees(
	id serial primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments(name) values ('it');
insert into departments(name) values ('sale');
insert into departments(name) values ('finance');
insert into departments(name) values ('logistic');
insert into departments(name) values ('transportation');
insert into departments(name) values ('justice');

insert into employees(name, department_id) values ('pavel', 1);
insert into employees(name, department_id) values ('ilon', 5);
insert into employees(name, department_id) values ('mark', 1);
insert into employees(name, department_id) values ('bill', 1);
insert into employees(name, department_id) values ('warren', 3);
insert into employees(name, department_id) values ('john', 3);
insert into employees(name, department_id) values ('bryan', 2);
insert into employees(name, department_id) values ('steve', 1);
insert into employees(name) values ('oryngali');


select * from departments d 
right join employees e 
on e.department_id = d.id;

select * from departments d 
left join employees e 
on e.department_id = d.id;


select * from departments cross join employees;

select * from employees e 
left join departments d 
on e.department_id = d.id 
where d.id is null;

--------------------------------------------------------

create table teens(
	id serial primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('pavel', 'male');
insert into teens(name, gender) values ('michael', 'male');
insert into teens(name, gender) values ('erbolat', 'male');
insert into teens(name, gender) values ('kuanysh', 'male');
insert into teens(name, gender) values ('serikbol', 'male');
insert into teens(name, gender) values ('aisana', 'female');
insert into teens(name, gender) values ('anelya', 'female');
insert into teens(name, gender) values ('samal', 'female');
insert into teens(name, gender) values ('saltanat', 'female');


select t1.name, t2.name, concat(t1.name, ' + ', t2.name) 
from teens t1 
cross join teens t2 
where t1.gender != t2.gender;

----------------------------------------------------------

create table body(
	id serial primary key,
	serial_number int
);

create table engine(
	id serial primary key,
	serial_number int
);

create table transmission(
	id serial primary key,
	serial_number int
);

create table car(
	id serial primary key,
	name varchar(255),
	body_id int references body(id) not null unique,
	engine_id int references engine(id) not null unique,
	transmission_id int references transmission(id) not null unique
);


insert into body(serial_number) values (1224);
insert into body(serial_number) values (485659);
insert into body(serial_number) values (2341224);
insert into body(serial_number) values (531224);
insert into body(serial_number) values (7561224);


insert into engine(serial_number) values (6783244);
insert into engine(serial_number) values (67867676);
insert into engine(serial_number) values (64554676);
insert into engine(serial_number) values (9856453);
insert into engine(serial_number) values (8356724);


insert into transmission(serial_number) values (775645);
insert into transmission(serial_number) values (3245423);
insert into transmission(serial_number) values (98753);
insert into transmission(serial_number) values (87566476);
insert into transmission(serial_number) values (456533);

insert into car(name, body_id, engine_id, transmission_id) values ('toyota', 1, 1, 1);
insert into car(name, body_id, engine_id, transmission_id) values ('honda', 2, 2, 2);
insert into car(name, body_id, engine_id, transmission_id) values ('huyindai', 3, 3, 3);
insert into car(name, body_id, engine_id, transmission_id) values ('kia', 4, 4, 4);


select c.name, 
b.serial_number as "body SN", 
e.serial_number as "engine SN", 
t.serial_number as "transmission SN"
from car as c 
left join body as b on c.body_id = b.id
join engine as e on c.engine_id = e.id
join transmission as t on c.transmission_id = t.id;

select b.serial_number as "body SN" 
from body as b 
left join car as c on c.body_id = b.id 
where c.name is null;

select e.serial_number as "engine SN" 
from engine as e 
left join car as c on c.engine_id = e.id 
where c.name is null;

select t.serial_number as "transmission SN" 
from transmission as t 
left join car as c on c.transmission_id = t.id 
where c.name is null;

-----------------------------------------------------------------------
