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

/*2. Выполнить запросы с left, rigth, full, cross соединениями*/
select * from departments d 
right join employees e 
on e.department_id = d.id;

select * from departments d 
left join employees e 
on e.department_id = d.id;

select * from departments cross join employees;


/*3. Используя left join найти департаменты, у которых нет работников*/
select * from employees e 
left join departments d 
on e.department_id = d.id 
where d.id is null;

/*4. Используя left и right join написать запросы, которые давали бы одинаковый результат.*/

select * from departments d 
right join employees e 
on e.department_id = d.id;

select * from employees e
left join departments d 
on e.department_id = d.id;
--------------------------------------------------------
/*5.1 Создать таблицу teens с атрибутами name, gender и заполнить ее.*/
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

/*5.2 Используя cross join составить все возможные разнополые пары*/

select t1.name, t2.name, concat(t1.name, ' + ', t2.name) 
from teens t1 
cross join teens t2 
where t1.gender != t2.gender;
